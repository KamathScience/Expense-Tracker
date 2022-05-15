package com.css533.curbthecoins.BudgetService.repositories;

import com.css533.curbthecoins.BudgetService.domain.Budget;
import com.css533.curbthecoins.BudgetService.exception.CCBadRequestException;
import com.css533.curbthecoins.BudgetService.exception.CCBudgetNotFoundException;

public interface IBudgetRepository {

    Budget findById(Integer userId, Integer partnerId) throws CCBudgetNotFoundException;

    Integer create(Integer userId, Integer partnerId, Double budget, String title, String description) throws CCBadRequestException;

    void update(Integer userId, Integer partnerId, Double budget, String title, String description) throws CCBadRequestException;

    void updatePartner(Integer userId, Integer partnerId) throws CCBadRequestException;

    void removeById(Integer userId, Integer partnerId);
}
