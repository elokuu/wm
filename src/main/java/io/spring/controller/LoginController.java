package io.spring.controller;

import io.spring.bean.User;
import io.spring.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    UserMapper userMapper;

    @PostMapping("/login")
    public String login(@RequestParam("name") String name,
                        @RequestParam("password") String password,
                        HttpSession session, Model model) {
        List<User> all = userMapper.getAll();

        for (User item : all) {
            if (name.equals(item.getName())) {
                if (password.equals(item.getPassword())) {
                    session.removeAttribute("msg");
                    session.setAttribute("name", name);
                    session.setAttribute("user", item);
                    model.addAttribute("msg", "success");
                    model.addAttribute("name", name);
                    return "redirect:/homepage";
                }
            }
        }

        session.setAttribute("name", "");
        session.setAttribute("msg", "账号或密码错误");
        return "redirect:/sign_in.html";
    }


    @PostMapping("/logup")
    public String logup(User user ,HttpSession session) {
        String username = user.getName();
        List<User> all = userMapper.getAll();
        for (User item : all) {
            if (username.equals(item.getName())) {
                session.setAttribute("msg", "用户名已存在");
                return "redirect:/sign_up.html";
            }
        }

        userMapper.insertUser(user);
        return "redirect:/sign_in.html";
    }
}
