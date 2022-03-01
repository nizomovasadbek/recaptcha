package org.recaptcha.utils;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AccessDenied {

    @ExceptionHandler(Exception.class)
    public String accessDeniedPage(){
        return "denied";
    }
}
