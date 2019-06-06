package com.likzn.lisblog.config;

import com.likzn.lisblog.config.interceptor.AdminInterceptor;
import com.likzn.lisblog.config.interceptor.ForeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @auther: Li jx
 * @date: 2019/6/3 16:38
 * @description:
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Autowired
    private AdminInterceptor adminInterceptor;
    @Autowired
    private ForeInterceptor foreInterceptor;


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("qweqweqweqwe/login.html");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(foreInterceptor).addPathPatterns("/**").excludePathPatterns("/login","/admin/**","/js/**","/css/**","/img/**","/fonts/**");
        registry.addInterceptor(adminInterceptor).addPathPatterns("/admin/**").excludePathPatterns("/login","/admin/login");
    }


}
