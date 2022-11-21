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
        System.out.println("4. Received fetch budget request, forwarding the request to budget repository");
        return budgetRepository.findById(userId, partnerId);
    }

    @Override
    public Budget createBudget(Integer userId, Integer partnerId, Double budget, String title, String description) throws CCBadRequestException {
        System.out.println("4. Received create/update budget request, forwarding the request to budget repository");
        if(budget <= 0){
            throw new CCBadRequestException("Budget cannot be below zero");
        }
        Integer count = budgetRepository.countById(userId, partnerId);
        System.out.println(count + " count is ");
        if(count == 0){
            budgetRepository.create(userId,partnerId,budget,title,description);
        }else{
            Budget budget1 = budgetRepository.findById(userId,partnerId);
            budgetRepository.update(budget1.getBudgetId(), budget, title, description);
        }
        return this.findBudgetById(userId,partnerId);
    }

    @Override
    public void updateBudgetPartner(Integer userId, Integer partnerId) throws CCBadRequestException {
        System.out.println("4. Received update budget partner request, forwarding the request to budget repository");
        budgetRepository.updatePartner(userId, partnerId);
    }
//
//    @Override
//    public void removeBudgetById(Integer userId, Integer partnerId) {
//        budgetRepository.removeById(userId, partnerId);
//    }
}
