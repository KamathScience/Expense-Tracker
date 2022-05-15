package com.css533.curbthecoins.PurchaseService.services;

import com.css533.curbthecoins.PurchaseService.domain.Transaction;
import com.css533.curbthecoins.PurchaseService.exceptions.CCBadRequestException;
import com.css533.curbthecoins.PurchaseService.exceptions.CCResourceNotFoundException;

import java.util.List;

public interface ITransactionService {

    List<Transaction> fetchAllTransactions(Integer userId, Integer partnerId,Integer categoryId);

    Transaction fetchTransactionById(Integer userId,Integer partnerId, Integer categoryId, Integer transactionId) throws CCResourceNotFoundException;

    Transaction addTransaction(Integer userId,Integer partnerId, Integer categoryId, Double amount, String note, Long transactionalDate) throws CCBadRequestException;

    void updateTransaction(Integer userId, Integer categoryId, Integer transactionId, Transaction transaction) throws CCBadRequestException;

    void removeTransaction(Integer userId,Integer partnerId, Integer categoryId, Integer transactionId) throws CCResourceNotFoundException;


}
