package io.spring.component;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginHandlerIntercepter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        Object user = request.getSession().getAttribute("user");
        if (user == null){
            request.setAttribute("msg","请先登录");
            request.getRequestDispatcher("/sign_in.html").forward(request,response);
            return false;
        }else {
            return true;
        }
    }
}
