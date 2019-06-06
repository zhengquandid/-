package com.likzn.lisblog.config.interceptor;

import com.likzn.lisblog.dao.LogRepository;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @auther: Li jx
 * @date: 2019/6/4 16:03
 * @description:
 */
@Component
public class ForeInterceptor implements HandlerInterceptor {
    @Autowired
    LogRepository logRepository;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取浏览器信息
        String ua = request.getHeader("User-Agent");
         //转成UserAgent对象
        UserAgent userAgent = UserAgent.parseUserAgentString(ua);

        String ip = request.getRemoteAddr();
        String operateBy = userAgent.getBrowser().getName()+"/"+userAgent.getOperatingSystem().getName();
        logRepository.insertLog(ip, operateBy);
        System.out.println(request.getContextPath());

        return true;
    }

}
