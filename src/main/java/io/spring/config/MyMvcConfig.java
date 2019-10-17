package io.spring.config;

import io.spring.component.AdminHandlerIntercepter;
import io.spring.component.LoginHandlerIntercepter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("redirect:/homepage");
        registry.addViewController("/sign_up.html").setViewName("register/sign_up");
        registry.addViewController("/sign_in.html").setViewName("register/sign_in");
        registry.addViewController("/dymainpage.html").setViewName("dymainpage");
        registry.addViewController("/authority.html").setViewName("error/authority");


        registry.addViewController("/pc-model.html").setViewName("pc-model");

        //订单中心/我的订单
        registry.addViewController("/per-order.html").setViewName("per-order");
        //订单中心/我的商品
        registry.addViewController("/per-foods.html").setViewName("per-foods");
        //订单中心/评价晒单
        registry.addViewController("/per-evaluation.html").setViewName("per-evaluation");
        //任务中心/我的任务
        registry.addViewController("/per-task.html").setViewName("per-task");
        //个人中心/我的首页
        registry.addViewController("/personalCenter.html").setViewName("personalCenter");
        //个人中心/我的收藏
        registry.addViewController("/per-favorite.html").setViewName("per-favorite");
        //个人中心/收货地址
        registry.addViewController("/per-address.html").setViewName("per-address");
        //账户管理/修改个人信息
        registry.addViewController("/perInfo.html").setViewName("perInfo");
        //账户管理/修改个人信息
        registry.addViewController("/per-renzheng.html").setViewName("per-renzheng");

        //他的个人中心
        registry.addViewController("/o-p-homepage.html").setViewName("o-p-homepage");
        //订单中心/审核
        registry.addViewController("/per-unaudited.html").setViewName("per-unaudited");

        registry.addViewController("/admin/useradd.html").setViewName("admin/useradd");
        registry.addViewController("/admin/password.html").setViewName("admin/password");

        //支付宝api测试
        registry.addViewController("/alipayTest").setViewName("alipayTest");
    }

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerIntercepter()).addPathPatterns("/dymainpage.html");
        registry.addInterceptor(new AdminHandlerIntercepter()).addPathPatterns("/admin/*");
    }
}
