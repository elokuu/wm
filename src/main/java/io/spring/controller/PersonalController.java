package io.spring.controller;

import io.spring.bean.*;
import io.spring.mapper.UserMapper;
import io.spring.tool.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        password = MD5.getInstance().getMD5(password);
        Map<String, String> map = new HashMap<>();
        map.put("name", (String) session.getAttribute("name"));
        map.put("password", password);
        map.put("email", email);
        userMapper.updateUser(map);
        User user = userMapper.getUser((String) session.getAttribute("name"));

        session.setAttribute("user", user);
        return "redirect:/personal";
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
        List<MyTask> otherTask = userMapper.getOtherTask(user.getId());
        myTask.addAll(otherTask);
        model.addAttribute("myTask", myTask);

        return "per-task";
    }

    @GetMapping("/my-per-task")
    public String MyPerTask(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");

        List<MyTask> myTask = userMapper.getMyTask(user.getId());
        model.addAttribute("myTask", myTask);

        return "per-task";
    }

    @GetMapping("/other-per-task")
    public String OtherPerTask(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");

        List<MyTask> otherTask = userMapper.getOtherTask(user.getId());
        model.addAttribute("myTask", otherTask);

        return "per-task";
    }

    @GetMapping("/per-foods")
    public String perFoods(HttpSession session, Model model) {

        User user = (User) session.getAttribute("user");

        List<MyGood> myGood = userMapper.getMyGood(user.getId());
        List<MyGood> otherGood = userMapper.getOtherGood(user.getId());
        myGood.addAll(otherGood);
        model.addAttribute("myGood", myGood);

        return "per-foods";
    }

    @GetMapping("/my-per-foods")
    public String MyPerFoods(HttpSession session, Model model) {

        User user = (User) session.getAttribute("user");

        List<MyGood> myGood = userMapper.getMyGood(user.getId());
        model.addAttribute("myGood", myGood);

        return "per-foods";
    }

    @GetMapping("/other-per-foods")
    public String OtherPerFoods(HttpSession session, Model model) {

        User user = (User) session.getAttribute("user");

        List<MyGood> myGood = userMapper.getOtherGood(user.getId());
        model.addAttribute("myGood", myGood);

        return "per-foods";
    }


    @GetMapping("/per-evaluation")
    public String perEvaluation(HttpSession session, Model model) {

        User user = (User) session.getAttribute("user");

        List<MyReview> myReview = userMapper.getMyReview(user.getId());
        List<MyReview> otherReview = userMapper.getOtherView(user.getId());
        myReview.addAll(otherReview);
        model.addAttribute("myReview", myReview);

        return "per-evaluation";
    }

    @GetMapping("/my-per-evaluation")
    public String MyPerEvaluation(HttpSession session, Model model) {

        User user = (User) session.getAttribute("user");

        List<MyReview> myReview = userMapper.getMyReview(user.getId());
        model.addAttribute("myReview", myReview);

        return "per-evaluation";
    }

    @GetMapping("/other-per-evaluation")
    public String OtherPerEvaluation(HttpSession session, Model model) {

        User user = (User) session.getAttribute("user");

        List<MyReview> myReview = userMapper.getOtherView(user.getId());
        model.addAttribute("myReview", myReview);

        return "per-evaluation";
    }

    @GetMapping("/o-p-homepage/{name}")
    public String OPHomepage(@PathVariable("name") String name,
                             Model model) {

        User user = userMapper.getUser(name);

        List<OtherMessage> otherHomepage = userMapper.getOtherHomepage(user.getId());

        model.addAttribute("otherHomepage", otherHomepage);
        model.addAttribute("user", user);

        return "o-p-homepage";
    }

    @GetMapping("/delete-myfavorgood/{id}")
    public String delMyFavorGood(HttpSession session,
                                 @PathVariable("id") int id_goods) {

        User user = (User) session.getAttribute("user");
        userMapper.deleteMyfavorgood(id_goods, user.getId());

        return "redirect:/per-favorite";
    }

    @PostMapping("/per-renzheng")
    public String perRenzheng(IdentificationMessage iden,
                              HttpSession session) {

        User user = (User) session.getAttribute("user");
        iden.setId_user(user.getId());
        userMapper.insertIdentification(iden);
        userMapper.updateValidateStatus(user.getId());

        return "per-renzheng";
    }

    @GetMapping("/gooddetail/{id_good}")
    public String goodDetail(@PathVariable("id_good") int id_good,
                             Model model) {

        MyGood goodDetail = userMapper.getGoodDetail(id_good);
        model.addAttribute("goodDetail", goodDetail);

        return "gooddetail";
    }
}
