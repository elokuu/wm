package io.spring.controller;

import io.spring.bean.Task;
import io.spring.bean.User;
import io.spring.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.sql.Date;

@Controller
public class TaskController {
    @Autowired
    TaskMapper taskMapper;
    @PostMapping("/task")
    public String publishTask(Task task, HttpSession session){
        User user = (User)(session.getAttribute("user"));
        task.setId_user(user.getId());
        task.setTime_create(new Date(System.currentTimeMillis()));
        task.setState(-1);
        taskMapper.publishTask(task);
        return "dymainpage";
    }
}
