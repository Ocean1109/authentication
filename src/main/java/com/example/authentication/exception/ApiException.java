package com.example.authentication.exception;

/**
 * 自定义资源(URL)被拦截时抛出的异常
 *
 * @author huhaiyang
 * @date 2022/1/12
 */
public class ApiException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String msg;

    public ApiException(String msg) {
        super(msg);
        this.msg = msg;
    }

}
