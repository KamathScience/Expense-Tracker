package com.css533.curbthecoins.PurchaseService.repositories;

import com.css533.curbthecoins.PurchaseService.domain.Transaction;
import com.css533.curbthecoins.PurchaseService.exceptions.CCBadRequestException;
import com.css533.curbthecoins.PurchaseService.exceptions.CCResourceNotFoundException;

import java.util.List;

public interface ITransactionRepository {

    List<Transaction> findAll(Integer userId,Integer partnerId, Integer categoryId);

    Transaction findById(Integer userId,Integer partnerId, Integer categoryId, Integer transactionId) throws CCResourceNotFoundException;

    Integer create(Integer userId, Integer categoryId, Double amount , String note , Long transactionDate) throws CCBadRequestException;

    void update(Integer userId, Integer categoryId, Integer transactionId, Transaction transaction) throws CCBadRequestException;

    void removeById(Integer userId,Integer partnerId, Integer categoryId, Integer transactionId) throws CCResourceNotFoundException;

}
