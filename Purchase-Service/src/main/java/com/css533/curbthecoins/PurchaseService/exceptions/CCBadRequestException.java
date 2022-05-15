package com.css533.curbthecoins.PurchaseService.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CCBadRequestException extends RuntimeException{

    public CCBadRequestException(String message){
        super(message);
    }

}
