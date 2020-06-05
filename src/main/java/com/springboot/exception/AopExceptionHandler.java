package com.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class AopExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String,Object>> handlerException(RuntimeException e, WebRequest request){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("STATUS","FAIL");
        return new ResponseEntity<Map<String,Object>>(result,HttpStatus.OK);
    }
}
