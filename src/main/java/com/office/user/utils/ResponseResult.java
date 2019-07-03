package com.office.user.utils;

import java.util.Objects;

public class ResponseResult<T> {

    private Integer code = 200;
    private String message;
    private T data;

    public ResponseResult() {
        super();
    }

    public ResponseResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseResult success(String message, T data) {
        ResponseResult<T> rr = new ResponseResult<>();
        this.code = 0;
        this.message = message;
        this.data = data;
        return rr;
    }

    public ResponseResult fail(String message, T data) {
        ResponseResult<T> rr = new ResponseResult<>();
        this.code = 1;
        this.message = message;
        this.data = data;
        return rr;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseResult<?> that = (ResponseResult<?>) o;
        return Objects.equals(code, that.code) &&
                Objects.equals(message, that.message) &&
                Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, message, data);
    }
}
