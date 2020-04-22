package com.duibuqi.common;


public class Result<T> {
    protected T data;
    protected String code;
    protected String message;


    public Result(String code, String message) {
        this.code = code;
        this.message = message;
        this.data=null;
    }

    public Result(T data){
        this.code = ResultEnum.SUCCESS.getCode();
        this.message=ResultEnum.SUCCESS.getMsg();
        this.data=data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
