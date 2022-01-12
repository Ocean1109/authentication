package com.example.authentication.config;

import com.example.authentication.constant.ResourceConstant;
import com.example.authentication.exception.ApiException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * URL拦截器
 *
 * @author huhaiyang
 * @date 2022/1/12
 */
public class UrlInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        String requestURL = request.getRequestURI();
        //1.根据token判断用户是否登录
        if (token == null) {
            // 如果没有token或者token不匹配, 直接抛出异常  提示未登录
            throw new ApiException("当前用户未登录");
        }
        //2.登录成功后 根据用户token中的信息获取到用户对应的URL权限集合
        List<String> list = ResourceConstant.permission.get(Integer.valueOf(token));
        if (list.contains(requestURL)) {
            return true;
        } else {
            throw new ApiException("当前用户没有访问路径" + requestURL + "的权限");
        }

    }
}
