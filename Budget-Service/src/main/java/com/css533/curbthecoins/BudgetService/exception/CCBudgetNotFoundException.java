package com.css533.curbthecoins.BudgetService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CCBudgetNotFoundException extends RuntimeException{


    public CCBudgetNotFoundException(String message){
        super(message);
    }
}
