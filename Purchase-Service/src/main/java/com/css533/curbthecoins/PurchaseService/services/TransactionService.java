package com.css533.curbthecoins.PurchaseService.services;

import com.css533.curbthecoins.PurchaseService.domain.Transaction;
import com.css533.curbthecoins.PurchaseService.exceptions.CCBadRequestException;
import com.css533.curbthecoins.PurchaseService.exceptions.CCResourceNotFoundException;
import com.css533.curbthecoins.PurchaseService.repositories.ITransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TransactionService implements  ITransactionService{

    @Autowired
    ITransactionRepository transactionRepository;

    @Override
    public List<Transaction> fetchAllTransactions(Integer userId, Integer partnerId,Integer categoryId) {
        return transactionRepository.findAll(userId,partnerId,categoryId);
    }

    @Override
    public Transaction fetchTransactionById(Integer userId, Integer partnerId,Integer categoryId, Integer transactionId) throws CCResourceNotFoundException {
        return transactionRepository.findById(userId, partnerId,categoryId, transactionId);
    }

    @Override
    public Transaction addTransaction(Integer userId, Integer partnerId,Integer categoryId, Double amount, String note, Long transactionalDate) throws CCBadRequestException {
        int transactionId = transactionRepository.create(userId, categoryId, amount, note, transactionalDate);
        return transactionRepository.findById(userId,partnerId, categoryId, transactionId);
    }

    @Override
    public void updateTransaction(Integer userId, Integer categoryId, Integer transactionId, Transaction transaction) throws CCBadRequestException {
        transactionRepository.update(userId,categoryId, transactionId, transaction);
    }

    @Override
    public void removeTransaction(Integer userId, Integer partnerId,Integer categoryId, Integer transactionId) throws CCResourceNotFoundException {
        transactionRepository.removeById(userId, partnerId, categoryId, transactionId);
    }
}
