package io.spring.controller;

import com.sun.xml.internal.ws.resources.HttpserverMessages;
import io.spring.bean.*;
import io.spring.mapper.GoodsMapper;
import io.spring.mapper.TaskMapper;
import io.spring.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class HPController {
    @Autowired
    TaskMapper taskMapper;
    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    UserMapper userMapper;

    @GetMapping("/homepage")
    public String homepage(HttpSession session){
       List<BriefTask> briefTasks =  taskMapper.getHomepageTaskInfo();
       session.setAttribute("briefTasks",briefTasks);
       List<BriefGoods> briefGoods = goodsMapper.getHomepageGoodsInfo();
       List<BriefGoods> briefGoods1 = briefGoods.subList(0,4);
       List<BriefGoods> briefGoods2 = briefGoods.subList(4,8);
       session.setAttribute("briefGoods1",briefGoods1);
       session.setAttribute("briefGoods2",briefGoods2);
       return "homepage";
    }

    @GetMapping("/MallHomepage.html")
    public String secmarket(HttpServletRequest request,
                            HttpSession session,
                            Model model){
        List<SecGoods> type1 = goodsMapper.getGoodsByType("电子产品");
        List<SecGoods> type2 = goodsMapper.getGoodsByType("电子产品");
        List<SecGoods> type3 = goodsMapper.getGoodsByType("电子产品");
        List<SecGoods> type4 = goodsMapper.getGoodsByType("电子产品");
        List<SecGoods> type5 = goodsMapper.getGoodsByType("电子产品");
        List<SecGoods> spec = goodsMapper.getSpecGoods();
        request.setAttribute("type1",type1);
        request.setAttribute("type2",type2);
        request.setAttribute("type3",type3);
        request.setAttribute("type4",type4);
        request.setAttribute("type5",type5);
        request.setAttribute("spec",spec);

        User user = (User) session.getAttribute("user");
        Map<String, Integer> map = new HashMap<>();
        map.put("favorGoodNum", userMapper.getFavorGoodNum(user.getId()));
        map.put("myGoodNum", userMapper.getMyGoodNum(user.getId()));
        map.put("otherGoodNum", userMapper.getOtherGoodNum(user.getId()));
        model.addAttribute("map", map);

        return "secmarket";
    }

    @GetMapping("/order")
    public String order(Model model,Integer id){
        Map<String,Object> goods = goodsMapper.getGoodsById(id);
        model.addAttribute("goods",goods);
        return "indent";
    }

}
