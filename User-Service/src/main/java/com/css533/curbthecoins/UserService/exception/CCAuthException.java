package com.css533.curbthecoins.UserService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class CCAuthException extends RuntimeException{

    public CCAuthException(String message){
        super(message);
    }
}

