package com.example.authentication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author huhaiyang
 * @date 2022/1/12
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    public UrlInterceptor urlInterceptor(){
        return new UrlInterceptor();
    }

    @Bean
    public UrlOperationInterceptor urlOperationInterceptor(){
        return new UrlOperationInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //权限拦截器
        registry.addInterceptor(urlInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(urlOperationInterceptor()).addPathPatterns("/**");
    }

}
