package com.css533.curbthecoins.PurchaseService.resources;


import com.css533.curbthecoins.PurchaseService.domain.Transaction;
import com.css533.curbthecoins.PurchaseService.services.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/categories/{categoryId}/transactions")

public class TransactionResourceController {
    @Autowired
    ITransactionService transactionService;

    @PostMapping("")
    @CrossOrigin
    public ResponseEntity<Transaction> addTransaction(HttpServletRequest request,
                                                      @PathVariable("categoryId") Integer categoryId,
                                                      @RequestBody Map<String, Object> transactionMap){
        System.out.println("1. Received request in Purchase service to add transaction for a particular category. Forwarding request to transaction-service-method ");
        int userId = (Integer) request.getAttribute("UserId");
        Integer partnerId = (Integer) request.getAttribute("Partner");
        Double amount = Double.valueOf(transactionMap.get("amount").toString());
        String note = (String) transactionMap.get("note");
        Long transactionDate = (Long) transactionMap.get("transactionDate");
        Transaction transaction = transactionService.addTransaction(userId, partnerId,categoryId,amount,note,transactionDate);
        System.out.println("1. Successfully added transaction");
        return new ResponseEntity<>(transaction, HttpStatus.CREATED);
    }

    @GetMapping("{transactionId}")
    @CrossOrigin
    public ResponseEntity<Transaction> getTransactionById(HttpServletRequest request,
                                                          @PathVariable("categoryId") Integer categoryId,
                                                          @PathVariable("transactionId") Integer transactionId){
        System.out.println("1. Received request in Purchase service to fetch particular transaction of particular category. Forwarding request to transaction-service-method ");
        int userId = (Integer) request.getAttribute("UserId");
        Integer partnerId = (Integer) request.getAttribute("Partner");
        Transaction transaction = transactionService.fetchTransactionById(userId,partnerId, categoryId, transactionId);
        System.out.println("1. Successfully fetched particular transaction");
        return new ResponseEntity<>(transaction, HttpStatus.OK);
    }

    @GetMapping("")
    @CrossOrigin
    public ResponseEntity<List<Transaction>> getAllTransactions(HttpServletRequest request,
                                                                @PathVariable("categoryId") Integer categoryId){
        System.out.println("1. Received request in Purchase service to fetch all transaction of particular category. Forwarding request to transaction-service-method ");
        int userId = (Integer) request.getAttribute("UserId");
        Integer partnerId = (Integer) request.getAttribute("Partner");
        List<Transaction> transactions = transactionService.fetchAllTransactions(userId,partnerId,categoryId);
        System.out.println("1. Successfully fetched all transaction");
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

    @PutMapping("/{transactionId}")
    @CrossOrigin
    public ResponseEntity<Map<String, Boolean>> updateTransaction(HttpServletRequest request,
                                                          @PathVariable("categoryId") Integer categoryId,
                                                          @PathVariable("transactionId") Integer transactionId,
                                                         @RequestBody Transaction transaction){
        System.out.println("1. Received request in Purchase service to fetch update a particular transaction of particular category. Forwarding request to transaction-service-method ");
        int userId = (Integer) request.getAttribute("UserId");
        transactionService.updateTransaction(userId, categoryId, transactionId, transaction);
        Map<String, Boolean> map = new HashMap<>();
        map.put("Success", true);
        System.out.println("1. Successfully updated transaction");
        return new ResponseEntity<>(map , HttpStatus.OK);
    }

    @DeleteMapping("/{transactionId}")
    @CrossOrigin
    public ResponseEntity<Map<String, Boolean>> deleteTransaction(HttpServletRequest request,
                                                                  @PathVariable("categoryId") Integer categoryId,
                                                                  @PathVariable("transactionId") Integer transactionId){
        System.out.println("1. Received request in Purchase service to delete a transaction of particular category. Forwarding request to transaction-service-method ");
        int userId = (Integer) request.getAttribute("UserId");
        Integer partnerId = (Integer) request.getAttribute("Partner");
        transactionService.removeTransaction(userId,partnerId,categoryId,transactionId);
        Map<String, Boolean> map = new HashMap<>();
        map.put("Success", true);
        System.out.println("1. Successfully deleted transaction");
        return new ResponseEntity<>(map , HttpStatus.OK);
    }

}
