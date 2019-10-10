package io.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("homepage");
        registry.addViewController("/sign_up.html").setViewName("register/sign_up");
        registry.addViewController("/sign_in.html").setViewName("register/sign_in");
        registry.addViewController("/MallHomepage.html").setViewName("MallHomepage");
        registry.addViewController("/personalCenter.html").setViewName("personalCenter");
        registry.addViewController("/dymainpage.html").setViewName("dymainpage");
        registry.addViewController("/dyhtml.html").setViewName("dyhtml");
    }

}
