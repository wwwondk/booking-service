package com.booking.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheckInterceptor extends HandlerInterceptorAdapter {
	
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            return true;
        } else {
            String url = request.getRequestURI();
            if (request.getQueryString() != null) {
                url += "?" + request.getQueryString();
            }
            session.setAttribute("path", url);
            RequestDispatcher rd = request.getRequestDispatcher("/login");
            rd.forward(request, response);
            return false;
        }
    }
}
