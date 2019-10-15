package io.spring.controller;

import io.spring.bean.*;
import io.spring.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PersonalController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("/personal")
    public String personalCenter(HttpSession session, Model model) {

        String name = (String) session.getAttribute("name");
        User user = userMapper.getUser(name);
        session.setAttribute("user", user);

        Map<String, Integer> NumMap = new HashMap<>();
        NumMap.put("allTaskNum", userMapper.getAllTaskNum(user.getId()));
        NumMap.put("allGoodNum", userMapper.getAllGoodNum(user.getId()));
        NumMap.put("allReviewNum", userMapper.getAllReviewNum(user.getId()));
        NumMap.put("favorGoodNum", userMapper.getFavorGoodNum(user.getId()));

        model.addAttribute("NumMap", NumMap);
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

    @GetMapping("/logout")
    public String logout(HttpSession session) {

        session.invalidate();
        return "homepage";
    }

    @GetMapping("/per-favorite")
    public String perFavorite(HttpSession session, Model model) {

        User user = (User) session.getAttribute("user");

        List<FavorGoods> favorGoods = userMapper.getFavorGoods(user.getId());
        model.addAttribute("favorGoods", favorGoods);

        return "per-favorite";
    }

    @GetMapping("/per-task")
    public String perTask(HttpSession session, Model model) {

        User user = (User) session.getAttribute("user");

        List<MyTask> myTask = userMapper.getMyTask(user.getId());
        model.addAttribute("myTask", myTask);

        return "per-task";
    }

    @GetMapping("/per-order")
    public String perOrder(HttpSession session, Model model) {

        User user = (User) session.getAttribute("user");

        List<MyGood> myGood = userMapper.getMyGood(user.getId());
        model.addAttribute("myGood", myGood);

        return "per-task";
    }
}
