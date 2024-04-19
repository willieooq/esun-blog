package com.esun.blog.utilities;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

import com.esun.blog.utilities.StatusCode;

@Getter
@Setter
public class Result {

    private Boolean success;
    private Integer code;
    private String message;
    private Map<String, Object> data = new HashMap<>();

    // 不使用無參數
    private Result() {
    }

    // 成功
    public static Result ok() {
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(StatusCode.SUCCESS);
        result.setMessage("成功");
        return result;
    }

    // 失敗
    public static Result failure() {
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(StatusCode.FAILURE);
        result.setMessage("失败");
        return result;
    }

    // 錯誤
    public static Result error() {
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(StatusCode.ERROR);
        result.setMessage("錯誤");
        return result;
    }

    public Result code(Integer code) {
        this.code = code;
        return this;
    }

    public Result data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public Result data(Map<String, Object> map) {
        this.data.putAll(map);
        return this;
    }

    public Result message(String message) {
        this.message = message;
        return this;
    }
}
