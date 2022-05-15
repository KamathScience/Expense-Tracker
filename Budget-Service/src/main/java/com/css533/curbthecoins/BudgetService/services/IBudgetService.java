package com.css533.curbthecoins.BudgetService.services;

import com.css533.curbthecoins.BudgetService.domain.Budget;
import com.css533.curbthecoins.BudgetService.exception.CCBadRequestException;
import com.css533.curbthecoins.BudgetService.exception.CCBudgetNotFoundException;

public interface IBudgetService {

    Budget findBudgetById(Integer userId, Integer partnerId) throws CCBudgetNotFoundException;

    Budget createBudget(Integer userId, Integer partnerId, Double budget, String title, String description) throws CCBadRequestException;

    void updateBudget(Integer userId, Integer partnerId, Double budget, String title, String description) throws CCBadRequestException;

    void updateBudgetPartner(Integer userId, Integer partnerId) throws CCBadRequestException;

    void removeBudgetById(Integer userId, Integer partnerId);
}
