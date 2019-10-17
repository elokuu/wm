package io.spring.controller;

import io.spring.bean.User;
import io.spring.config.EmailConfig;
import io.spring.mapper.UserMapper;
import io.spring.tool.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Controller
public class LoginController {

    @Autowired
    UserMapper userMapper;
    @Autowired
    EmailConfig javaMailSender;

    @PostMapping("/login")
    public String login(@RequestParam("name") String name,
                        @RequestParam("password") String password,
                        HttpSession session, Model model) {
        List<User> all = userMapper.getAll();
        String md5password = MD5.getInstance().getMD5(password);
        for (User item : all) {
            if (name.equals(item.getName())) {
                if (md5password.equals(item.getPassword())) {
                    session.removeAttribute("msg");
                    session.setAttribute("name", name);
                    session.setAttribute("user", item);
                    model.addAttribute("msg", "success");
                    model.addAttribute("name", name);
                    if (item.getAuthority() == 2){
                        return "redirect:/admin/userlist";
                    }else {
                        return "redirect:/homepage";
                    }
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
        String password = user.getPassword();
        user.setPassword(MD5.getInstance().getMD5(password));
        userMapper.insertUser(user);
//        return "redirect:/sign_in.html";
        return "redirect:/sendMail?tar="+user.getEmail();
    }

    @GetMapping("/sendMail")
    public String sendMail(String tar, Model model){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("airyvoices@163.com");
        message.setTo(tar);
        message.setSubject("校园任务平台注册码");

        //生成验证码
        String str="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb=new StringBuilder(6);
        for(int i=0;i<6;i++)
        {
            char ch=str.charAt(new Random().nextInt(str.length()));
            sb.append(ch);
        }
        String validate = sb.toString();
        model.addAttribute("email",tar);
        model.addAttribute("validate",validate);
        message.setText("您本次的验证码是: "+validate);
        javaMailSender.javaMailSender().send(message);

        return "validateEmail";
    }
    @PostMapping("/confirmEmail")
    public String confirmEmail(Integer id){
        Map<String,Integer> map = new HashMap<String ,Integer>();
        map.put("id",id);
        map.put("state",1);
        userMapper.updateState(map);
        return "redirect:/sign_in.html";
    }
}
