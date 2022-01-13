package com.example.authentication.constant;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huhaiyang
 * @date 2022/1/13
 */
public class RoleConstant {
    public static Map<Integer, List<String>> permission = new HashMap<>();
    /**
     *全部的模块
     */
    public static List<String> allRole = Arrays.asList("test", "test1");

    static {
        //用户1所拥有的模块权限  这里的test是模块URL入口  例如：test模块下所有URL都是/test/**
        List<String> first = Arrays.asList("test", "test1");
        //用户2所拥有的模块权限
        List<String> second = Arrays.asList("test");
        permission.put(1, first);
        permission.put(2, second);
    }
}
