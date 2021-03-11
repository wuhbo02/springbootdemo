package com.ygnet.springbootdemo.pojo;

import lombok.Data;

import java.util.Map;

@Data
public class Result<T> {

    private Integer code=200;
    private String msg="操作成功";
    private String description;
    private T data;

    public Result setData(T data) {
        this.data = data;
        return this;
    }

    public Result() {
    }

    public static Result failure(int code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static Result ok(String msg) {
        Result result = new Result();
        result.setMsg(msg);
        return result;
    }

    public static Result ok(Map<String, Object> map) {
        Result result = new Result();
        result.setData(map);
        return result;
    }

    public static Result ok() {
        return new Result();
    }


}
