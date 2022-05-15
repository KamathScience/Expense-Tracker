package com.css533.curbthecoins.PurchaseService.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CCResourceNotFoundException extends RuntimeException{


    public CCResourceNotFoundException(String message){
        super(message);
    }
}
