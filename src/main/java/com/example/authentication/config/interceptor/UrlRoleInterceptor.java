package com.example.authentication.config.interceptor;

import com.example.authentication.constant.RoleConstant;
import com.example.authentication.exception.ApiException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author huhaiyang
 * @date 2022/1/13
 */
public class UrlRoleInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        String requestURL = request.getRequestURI();
        //1.截取URL前一部分对应的模块名字
        String[] split = requestURL.split("/");
        //不在角色权限判断的范围内
        if (null == split[1] || !RoleConstant.allRole.contains(split[1])) {
            return true;
        }

        //2.根据token判断用户是否登录
        if (token == null) {
            // 如果没有token或者token不匹配, 直接抛出异常  提示未登录
            throw new ApiException("当前用户未登录");
        }
        //3.登录成功后 根据用户token中的信息获取到用户对应的URL权限集合
        List<String> list = RoleConstant.permission.get(Integer.valueOf(token));
        if (list.contains(split[1])) {
            return true;
        } else {
            throw new ApiException("角色权限问题：当前用户没有访问路径" + requestURL + "的权限");
        }

    }
}
