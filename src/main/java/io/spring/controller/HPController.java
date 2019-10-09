package io.spring.controller;

import io.spring.bean.BriefGoods;
import io.spring.bean.BriefTask;
import io.spring.mapper.GoodsMapper;
import io.spring.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class HPController {
    @Autowired
    TaskMapper taskMapper;
    @Autowired
    GoodsMapper goodsMapper;

    @GetMapping("/homepage")
    public String getHomepageTaskInfo(HttpSession session){
       List<BriefTask> briefTasks =  taskMapper.getHomepageTaskInfo();
       session.setAttribute("briefTasks",briefTasks);
       List<BriefGoods> briefGoods = goodsMapper.getHomepageGoodsInfo();
       List<BriefGoods> briefGoods1 = briefGoods.subList(0,4);
       List<BriefGoods> briefGoods2 = briefGoods.subList(4,8);
       session.setAttribute("briefGoods1",briefGoods1);
       session.setAttribute("briefGoods2",briefGoods2);
       return "homepage";
    }

}
