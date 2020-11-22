package com.acadena.BlackFridayAnalyzer.price.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PriceAdvice {

    @ResponseBody
    @ExceptionHandler(PriceException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    String PriceAdvice(PriceException ex){
        return ex.getMessage();
    }
}
