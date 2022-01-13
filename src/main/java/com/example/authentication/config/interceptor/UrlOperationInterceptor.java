package com.example.authentication.config.interceptor;

import com.example.authentication.annotation.UrlAnnotation;
import com.example.authentication.constant.CRUDConstant;
import com.example.authentication.exception.ApiException;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author huhaiyang
 * @date 2022/1/12
 */
public class UrlOperationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        String requestURL = request.getRequestURI();
        //1.获取对应的注解上的type，获取不到默认无权限
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        UrlAnnotation urlAnnotation = method.getAnnotation(UrlAnnotation.class);
        if (urlAnnotation == null) {
            return true;
        }
        String type = urlAnnotation.type();
        //2.登录成功后 根据用户token中的信息获取到用户对应的URL权限集合
        List<String> list = CRUDConstant.permission.get(Integer.valueOf(token));
        if (list.contains(type)) {
            return true;
        } else {
            throw new ApiException("操作权限问题：当前用户没有访问路径" + requestURL + "的权限");
        }

    }
}
