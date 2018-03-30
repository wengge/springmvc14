package com.newer.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*@ControllerAdvice*/
//定义所有Controller都执行的异常处理
public class TestErrorController {

    @ExceptionHandler
    public String HandleExcp(Exception ex){
        System.out.println(ex.getMessage());
        return "error";
    }
}
