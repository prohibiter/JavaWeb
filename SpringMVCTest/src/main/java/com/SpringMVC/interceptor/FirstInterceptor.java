package com.SpringMVC.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class FirstInterceptor implements HandlerInterceptor {
    //控制器方法直行之前执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("firstInterceptor-->preHandler");
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    //控制器方法执行之后执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("firstInterceptor-->postHandler");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    //视图渲染之后
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("firstInterceptor-->afterCompletion");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
