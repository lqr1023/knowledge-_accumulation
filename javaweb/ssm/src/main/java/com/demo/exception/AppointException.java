package com.demo.exception;

/**
 * @Author:
 * @Description:
 * @Data:Created in 14:58 2018/9/17
 */
public class AppointException extends RuntimeException {
    public AppointException(String message) {
        super(message);
    }

    public AppointException(String message, Throwable cause) {
        super(message, cause);
    }
}
