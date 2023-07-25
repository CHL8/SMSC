package com.hp.config;

import com.hp.web.interceptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private MyInterceptor myInterceptor;
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/admin").setViewName("admin");
        registry.addViewController("/index/index").setViewName("index/index");
        registry.addViewController("/index/login").setViewName("index/login");
        registry.addViewController("/index/footer").setViewName("index/footer");
        registry.addViewController("/index/register").setViewName("index/register");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor).addPathPatterns("/**").excludePathPatterns("/admin/login");
    }
}
