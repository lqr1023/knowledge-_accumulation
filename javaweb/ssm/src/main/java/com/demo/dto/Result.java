package com.demo.dto;

/**
 * @Author:
 * @Description: 封装json对象
 * @Data:Created in 16:22 2018/9/17
 */
public class Result<T> {
    private boolean flag;// 是否成功标志

    private T data;// 成功时返回的数据

    private String error;// 错误信息

    public Result(){}

    //成功时返回的数据
    public Result(boolean flag, T data) {
        this.flag = flag;
        this.data = data;
    }

    public Result(boolean flag, String error) {
        this.flag = flag;
        this.error = error;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
