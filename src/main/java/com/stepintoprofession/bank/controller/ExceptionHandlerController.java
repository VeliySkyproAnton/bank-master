package com.stepintoprofession.bank.controller;

import com.stepintoprofession.bank.exception.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<Object> handleException(ServiceException e) {
        return new ResponseEntity<>(e.getMessage(), e.getStatus());
    }
}
