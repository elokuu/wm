package io.spring.controller;

import io.spring.bean.BriefGoods;
import io.spring.bean.BriefTask;
import io.spring.bean.SecGoods;
import io.spring.mapper.GoodsMapper;
import io.spring.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class HPController {
    @Autowired
    TaskMapper taskMapper;
    @Autowired
    GoodsMapper goodsMapper;

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
    public String secmarket(HttpServletRequest request){
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

        return "secmarket";
    }

}
