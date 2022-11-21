package com.css533.curbthecoins.PurchaseService.resources;

import com.css533.curbthecoins.PurchaseService.domain.Transaction;
import com.css533.curbthecoins.PurchaseService.services.TransactionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
class TransactionResourceControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TransactionService transactionService;

    @Test
    public void shouldGetAllTransactionsTest() throws Exception{
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.setAttribute("UserId" , "1");
        httpServletRequest.setAttribute("Partner" , "2");
        List<Transaction> transactions = new ArrayList<>();
        when(transactionService.fetchAllTransactions(1, 2 , 1)).thenReturn(transactions);
        mockMvc.perform(get("/api/categories/1/transactions?httpServletRequest")).andDo(print()).andExpect(status().isForbidden());
    }

    @Test
    public void shouldPostTransactionTest() throws Exception{
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.setAttribute("UserId" , "1");
        httpServletRequest.setAttribute("Partner" , "2");
        Map<String , Object> transactionMap = new HashMap<>();
        transactionMap.put("amount", 500.00);
        transactionMap.put("note", "note");
        transactionMap.put("date", 123456789);
        Transaction transaction = new Transaction(1,1,1, 500.00, "note", Long.valueOf(123456789));
        when(transactionService.addTransaction(1, 2, 1, 500.00,"note",  Long.valueOf(123456789))).thenReturn(transaction);
        mockMvc.perform(post("/api/categories/1/transactions?httpServletRequest")).andDo(print()).andExpect(status().isForbidden());

    }

    @Test
    public void shouldGetTransactionTest() throws Exception{
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.setAttribute("UserId" , "1");
        httpServletRequest.setAttribute("Partner" , "2");
        Transaction transaction = new Transaction(1,1,1, 500.00, "note", Long.valueOf(123456789));
        when(transactionService.fetchTransactionById(1, 2, 1,1)).thenReturn(transaction);
        mockMvc.perform(get("/api/categories/1/transactions/1?httpServletRequest")).andDo(print()).andExpect(status().isForbidden());
    }

    @Test
    public void shouldUpdateTRansactionTest() throws Exception{
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.setAttribute("UserId" , "1");
        httpServletRequest.setAttribute("Partner" , "2");
        Transaction transaction = new Transaction(1,1,1, 500.00, "note", Long.valueOf(123456789));
        mockMvc.perform(put("/api/categories/1/transactions?httpServletRequest,transaction")).andDo(print()).andExpect(status().isForbidden());
    }

    @Test
    public void shouldDeleteCategoryTest() throws Exception{
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.setAttribute("UserId" , "1");
        httpServletRequest.setAttribute("Partner" , "2");
        Transaction transaction = new Transaction(1,1,1, 500.00, "note", Long.valueOf(123456789));
        mockMvc.perform(put("/api/categories/1?httpServletRequest")).andDo(print()).andExpect(status().isForbidden());
    }

    @Test
    public void shouldGetAllTransactionsValidTest() throws Exception{
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.setAttribute("UserId" , "1");
        httpServletRequest.setAttribute("Partner" , "2");
        List<Transaction> transactions = new ArrayList<>();
        when(transactionService.fetchAllTransactions(1, 2 , 1)).thenReturn(transactions);
        mockMvc.perform(get("/api/categories/1/transactions?httpServletRequest")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void shouldPostTransactionValidTest() throws Exception{
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.setAttribute("UserId" , "1");
        httpServletRequest.setAttribute("Partner" , "2");
        Map<String , Object> transactionMap = new HashMap<>();
        transactionMap.put("amount", 500.00);
        transactionMap.put("note", "note");
        transactionMap.put("date", 123456789);
        Transaction transaction = new Transaction(1,1,1, 500.00, "note", Long.valueOf(123456789));
        when(transactionService.addTransaction(1, 2, 1, 500.00,"note",  Long.valueOf(123456789))).thenReturn(transaction);
        mockMvc.perform(post("/api/categories/1/transactions?httpServletRequest")).andDo(print()).andExpect(status().isOk());

    }

    @Test
    public void shouldGetTransactionValidTest() throws Exception{
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.setAttribute("UserId" , "1");
        httpServletRequest.setAttribute("Partner" , "2");
        Transaction transaction = new Transaction(1,1,1, 500.00, "note", Long.valueOf(123456789));
        when(transactionService.fetchTransactionById(1, 2, 1,1)).thenReturn(transaction);
        mockMvc.perform(get("/api/categories/1/transactions/1?httpServletRequest")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void shouldUpdateTRansactionValidTest() throws Exception{
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.setAttribute("UserId" , "1");
        httpServletRequest.setAttribute("Partner" , "2");
        Transaction transaction = new Transaction(1,1,1, 500.00, "note", Long.valueOf(123456789));
        mockMvc.perform(put("/api/categories/1/transactions?httpServletRequest,transaction")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void shouldDeleteCategoryValidTest() throws Exception{
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.setAttribute("UserId" , "1");
        httpServletRequest.setAttribute("Partner" , "2");
        Transaction transaction = new Transaction(1,1,1, 500.00, "note", Long.valueOf(123456789));
        mockMvc.perform(put("/api/categories/1?httpServletRequest")).andDo(print()).andExpect(status().isOk());
    }
}