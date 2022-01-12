package com.example.authentication.constant;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 资源权限(URL即为资源)
 *
 * @author huhaiyang
 * @date 2022/1/12
 */
public class ResourceConstant {
    public static Map<Integer, List<String>> permission = new HashMap<>();

    static {
        //用户1所拥有的URL权限
        List<String> first = Arrays.asList("/url1", "/url2", "/url3", "/url4", "/url5", "/url6", "/url7");
        //用户2所拥有的URL权限
        List<String> second = Arrays.asList("/url1", "/url2", "/url3", "/url4", "/url5");
        //用户3所拥有的URL权限
        List<String> third = Arrays.asList("/url1", "/url2", "/url3");
        permission.put(1, first);
        permission.put(2, second);
        permission.put(3, third);
    }
}
