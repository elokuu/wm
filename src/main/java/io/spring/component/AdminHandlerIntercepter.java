package io.spring.component;

import io.spring.bean.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminHandlerIntercepter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        Object o = request.getSession().getAttribute("user");
        if (o == null){
            response.sendRedirect("/sign_in.html");
            return false;
        }else {
            User user = (User) o;
            if (user.getAuthority() == 2){
                return true;
            }else {
                response.sendRedirect("/authority.html");
                return false;
            }
        }
    }
}