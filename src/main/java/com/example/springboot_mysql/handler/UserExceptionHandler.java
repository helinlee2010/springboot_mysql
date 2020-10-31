package com.example.springboot_mysql.handler;

import com.example.springboot_mysql.InvalidFieldException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler
    public String handleInvalidFieldException(InvalidFieldException e){
        return e.getMessage();
    }
}
