package io.spring.controller;

import io.spring.bean.Goods;
import io.spring.bean.Task;
import io.spring.bean.User;
import io.spring.mapper.GoodsMapper;
import io.spring.mapper.TaskMapper;
import io.spring.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    TaskMapper taskMapper;

    @GetMapping("/userlist")
    public String userlist(Model model){
        List<User> users = userMapper.getAll();
        model.addAttribute("users",users);
        return "admin/userlist";
    }
    @GetMapping("/updateUserState")
    public String updateUserState(Integer id, Integer state){
        Map<String,Integer> map = new HashMap<String ,Integer>();
        map.put("id",id);
        map.put("state",state);
        userMapper.updateState(map);
        return "redirect:/admin/userlist";
    }
    @PostMapping("/addUser")
    public String addUser(User user){
        userMapper.addUser(user);
        return "redirect:/admin/userlist";
    }
    @GetMapping("/goodsPage")
    public String goodsPage(Integer state, Model model){
        List<Goods> goodsList = goodsMapper.getAllByState(state);
        model.addAttribute("goodsList",goodsList);
        model.addAttribute("pageState",state);
        return "admin/goods";
    }
    @GetMapping("/updateGoodsState")
    public String updateGoodsState(Integer id, Integer state, Integer pageState){
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("id",id);
        map.put("state",state);
        goodsMapper.updateState(map);
        return "redirect:/admin/goodsPage?state="+pageState;
    }
    @GetMapping("/taskPage")
    public String taskPage(Integer state, Model model){
        List<Task> goodsList = taskMapper.getAllByState(state);
        model.addAttribute("tasks",goodsList);
        model.addAttribute("pageState",state);
        return "admin/task";
    }
    @GetMapping("/updateTaskState")
    public String updateTaskState(Integer id, Integer state, Integer pageState){
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("id",id);
        map.put("state",state);
        taskMapper.updateState(map);
        return "redirect:/admin/taskPage?state="+pageState;
    }
    @PostMapping("/updateAdminPassword")
    public String updateAdminPassword(String password, HttpSession session){
        Map<String, Object> map = new HashMap<String, Object>();
        User user = (User) session.getAttribute("user");
        map.put("id",user.getId());
        map.put("password",password);
        userMapper.updatePassword(map);
        return "admin/password";
    }
}
