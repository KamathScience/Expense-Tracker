package com.css533.curbthecoins.BudgetService.services;

import com.css533.curbthecoins.BudgetService.domain.Budget;
import com.css533.curbthecoins.BudgetService.exception.CCBadRequestException;
import com.css533.curbthecoins.BudgetService.exception.CCBudgetNotFoundException;
import com.css533.curbthecoins.BudgetService.repositories.IBudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BudgetService implements IBudgetService{

    @Autowired
    IBudgetRepository budgetRepository;

    @Override
    public Budget findBudgetById(Integer userId, Integer partnerId) throws CCBudgetNotFoundException {
        return budgetRepository.findById(userId, partnerId);
    }

    @Override
    public Budget createBudget(Integer userId, Integer partnerId, Double budget, String title, String description) throws CCBadRequestException {
        System.out.println("Inside add budget services userID " + userId+" partnerID " + partnerId );
        int budgetId = budgetRepository.create(userId,partnerId,budget,title,description);
        return this.findBudgetById(userId,partnerId);

    }

    @Override
    public void updateBudget(Integer userId, Integer partnerId, Double budget, String title, String description) throws CCBadRequestException {
        budgetRepository.update(userId, partnerId, budget, title, description);
    }

    @Override
    public void updateBudgetPartner(Integer userId, Integer partnerId) throws CCBadRequestException {
        budgetRepository.updatePartner(userId, partnerId);
    }

    @Override
    public void removeBudgetById(Integer userId, Integer partnerId) {
        budgetRepository.removeById(userId, partnerId);
    }
}
