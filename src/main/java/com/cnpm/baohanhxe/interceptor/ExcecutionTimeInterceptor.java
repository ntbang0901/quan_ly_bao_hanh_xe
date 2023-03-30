package com.cnpm.baohanhxe.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class ExcecutionTimeInterceptor implements HandlerInterceptor {


    private static  final Logger log = LoggerFactory.getLogger(ExcecutionTimeInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String ipAddress = request.getHeader("User-Agent");
        log.info("---Pre Handle:::-----");
        log.info("Request Browser:: " + ipAddress);
        log.info("Request URL:: " + request.getRequestURI());
        request.setAttribute("startTime",System.currentTimeMillis());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("---post Handle:::-----");
        log.info("Request URL:: " + request.getRequestURI());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("---after complete Handle:::-----");
        log.info("Request URL:: " + request.getRequestURI());
        long executed = System.currentTimeMillis() - (long) request.getAttribute("startTime");
        log.info("execution time ms : {}" , executed );
    }
}
