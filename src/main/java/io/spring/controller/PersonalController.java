package io.spring.controller;

import io.spring.bean.User;
import io.spring.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class PersonalController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("/personal")
    public String personalCenter(HttpSession session) {

        String name = (String) session.getAttribute("name");
        User user = userMapper.getUser(name);

       session.setAttribute("user", user);
        return "personalCenter";
    }

    @PostMapping("/update")
    public String update(@RequestParam("password") String password,
                         @RequestParam("email") String email,
                         HttpSession session) {

        userMapper.updateUser((String) session.getAttribute("name"), password, email);
        User user = userMapper.getUser((String) session.getAttribute("name"));

        session.setAttribute("user", user);
        return "personalCenter";
    }
}
