package com.example.authentication.controller;

import com.example.authentication.exception.ApiException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 *
 * @author huhaiyang
 * @date 2022/1/12
 */
@RestControllerAdvice
public class WebExceptionController {

    @ExceptionHandler(ApiException.class)
    public String apiExceptionHandler(ApiException e) {
        return e.getMessage();
    }
}
