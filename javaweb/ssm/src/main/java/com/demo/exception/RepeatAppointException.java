package com.demo.exception;

/**
 * @Author:
 * @Description: 重复预约异常
 * @Data:Created in 14:56 2018/9/17
 */
public class RepeatAppointException extends RuntimeException {
    public RepeatAppointException(String message) {
        super(message);
    }

    public RepeatAppointException(String message, Throwable cause) {
        super(message, cause);
    }
}
