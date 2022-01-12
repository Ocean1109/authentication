package com.example.authentication.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义URL操作权限的注解
 *
 * @author huhaiyang
 * @date 2022/1/12
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UrlAnnotation {
    /**
     * 操作类型(type):添加,删除,修改,插入
     *
     */
    String type();
}
