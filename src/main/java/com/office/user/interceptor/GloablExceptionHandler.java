package com.office.user.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.office.user.utils.ResponseResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 */
@ControllerAdvice
public class GloablExceptionHandler {
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResponseResult<String> handleException(Exception e) {
        ResponseResult<String> rr = new ResponseResult<>();
        String msg = e.getMessage();
        if (msg == null || msg.equals("")) {
            rr.fail("服务器出错!", null);
        }
        rr.fail(msg, null);
        return rr;
    }
}
