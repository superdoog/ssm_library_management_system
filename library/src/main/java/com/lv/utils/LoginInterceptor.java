package com.lv.utils;

import com.lv.pojo.Admin;
import com.lv.pojo.ReaderInfo;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

//        request.getSession().getAttribute(Constants.USER_SESSION)
//        ReaderInfo reader = (ReaderInfo) request.getSession().getAttribute(Constants.USER_SESSION);
//        Admin admin = (Admin) request.getSession().getAttribute(Constants.USER_SESSION);

        if (request.getSession().getAttribute(Constants.USER_SESSION) instanceof Admin) {
            Admin admin = (Admin) request.getSession().getAttribute(Constants.USER_SESSION);
            if (admin == null) { //session过期
                //跳转到登录页面
                request.getRequestDispatcher("/adminLogin.jsp").forward(request, response);
                return false;
            }
        }
        if (request.getSession().getAttribute(Constants.USER_SESSION) instanceof ReaderInfo) {
            ReaderInfo reader = (ReaderInfo) request.getSession().getAttribute(Constants.USER_SESSION);
            if (reader == null) { //session过期
                //跳转到登录页面
                request.getRequestDispatcher("/readerLogin.jsp").forward(request, response);
                return false;
            }
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
