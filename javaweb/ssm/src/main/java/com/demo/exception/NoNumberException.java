package com.demo.exception;

/**
 * @Author:
 * @Description: 库存不足异常
 * @Data:Created in 14:50 2018/9/17
 */
public class NoNumberException extends RuntimeException{

    public NoNumberException(String message) {
        super(message);
    }

    public NoNumberException(String message,Throwable cause){
        super(message,cause);
    }


}
