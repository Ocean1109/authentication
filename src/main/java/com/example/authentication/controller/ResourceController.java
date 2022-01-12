package com.example.authentication.controller;

import com.example.authentication.annotation.UrlAnnotation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  资源权限controller层
 *
 * @author huhaiyang
 * @date 2022/1/12
 */
@RestController
public class ResourceController {

    private final String HAVE_AUTH = "恭喜你，你有此URL的权限";

    @UrlAnnotation(type = "select")
    @RequestMapping(value = "/url1")
    public String url1(){
        return HAVE_AUTH;
    }

    @UrlAnnotation(type = "delete")
    @RequestMapping(value = "/url2")
    public String url2(){
        return HAVE_AUTH;
    }

    @UrlAnnotation(type = "insert")
    @RequestMapping(value = "/url3")
    public String url3(){
        return HAVE_AUTH;
    }

    @UrlAnnotation(type = "update")
    @RequestMapping(value = "/url4")
    public String url4(){
        return HAVE_AUTH;
    }

    @RequestMapping(value = "/url5")
    public String url5(){
        return HAVE_AUTH;
    }

    @RequestMapping(value = "/url6")
    public String url6(){
        return HAVE_AUTH;
    }

    @RequestMapping(value = "/url7")
    public String url7(){
        return HAVE_AUTH;
    }
}
