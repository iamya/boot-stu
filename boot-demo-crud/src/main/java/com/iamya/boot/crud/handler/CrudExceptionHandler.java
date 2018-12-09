package com.iamya.boot.crud.handler;

import com.iamya.boot.crud.exception.UserForbidException;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CrudExceptionHandler {

    @ExceptionHandler(UserForbidException.class)
    public String handlerUserForbidException(Exception e, HttpServletRequest request) {

        //存储自定义错误信息
        Map<String, Object> map = new HashMap<>();
        map.put("code", "user borbid");
        map.put("message", "this is a test");
        request.setAttribute("ext", map);

        //设置错误码(只有4xx和5xx能被BasicErrorController识别
        request.setAttribute("javax.servlet.error.status_code",500);
        //转发到默认处理页面
        return "forward:/error";
    }
}
