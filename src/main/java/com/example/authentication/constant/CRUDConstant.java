package com.example.authentication.constant;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 操作的权限控制（增删改查）
 *
 * @author huhaiyang
 * @date 2022/1/12
 */
public class CRUDConstant {
    public static Map<Integer, List<String>> permission = new HashMap<>();

    static {
        //用户1所拥有的操作权限
        List<String> first = Arrays.asList("insert", "delete", "select", "update");
        //用户2所拥有的URL权限
        List<String> second = Arrays.asList("insert", "select", "update");
        //用户3所拥有的URL权限
        List<String> third = Arrays.asList("select");
        permission.put(1, first);
        permission.put(2, second);
        permission.put(3, third);

    }
}
