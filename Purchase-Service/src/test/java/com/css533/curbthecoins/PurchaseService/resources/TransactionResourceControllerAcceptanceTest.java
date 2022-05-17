package com.css533.curbthecoins.PurchaseService.resources;

import com.css533.curbthecoins.PurchaseService.services.TransactionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TransactionResourceControllerAcceptanceTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TransactionService transactionService;

    @Test
    public void shouldGetAllTransactionsTest() throws Exception{
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.setAttribute("UserId" , "1");
        httpServletRequest.setAttribute("Partner" , "2");
        mockMvc.perform(get("/api/categories/1/transactions?httpServletRequest")).andDo(print()).andExpect(status().isForbidden());
    }

    @Test
    public void shouldPostTransactionTest() throws Exception{
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.setAttribute("UserId" , "1");
        httpServletRequest.setAttribute("Partner" , "2");
        mockMvc.perform(post("/api/categories/1/transactions?httpServletRequest")).andDo(print()).andExpect(status().isForbidden());

    }

    @Test
    public void shouldGetTransactionTest() throws Exception{
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.setAttribute("UserId" , "1");
        httpServletRequest.setAttribute("Partner" , "2");
        mockMvc.perform(get("/api/categories/1/transactions/1?httpServletRequest")).andDo(print()).andExpect(status().isForbidden());
    }

    @Test
    public void shouldUpdateTRansactionTest() throws Exception{
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.setAttribute("UserId" , "1");
        httpServletRequest.setAttribute("Partner" , "2");
        mockMvc.perform(put("/api/categories/1/transactions?httpServletRequest,transaction")).andDo(print()).andExpect(status().isForbidden());
    }

    @Test
    public void shouldDeleteCategoryTest() throws Exception{
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.setAttribute("UserId" , "1");
        httpServletRequest.setAttribute("Partner" , "2");
        mockMvc.perform(put("/api/categories/1?httpServletRequest")).andDo(print()).andExpect(status().isForbidden());
    }

    @Test
    public void shouldGetAllTransactionsValidTest() throws Exception{
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.setAttribute("UserId" , "1");
        httpServletRequest.setAttribute("Partner" , "2");
        mockMvc.perform(get("/api/categories/1/transactions?httpServletRequest")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void shouldPostTransactionValidTest() throws Exception{
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.setAttribute("UserId" , "1");
        httpServletRequest.setAttribute("Partner" , "2");
        mockMvc.perform(post("/api/categories/1/transactions?httpServletRequest")).andDo(print()).andExpect(status().isOk());

    }

    @Test
    public void shouldGetTransactionValidTest() throws Exception{
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.setAttribute("UserId" , "1");
        httpServletRequest.setAttribute("Partner" , "2");
        mockMvc.perform(get("/api/categories/1/transactions/1?httpServletRequest")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void shouldUpdateTRansactionValidTest() throws Exception{
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.setAttribute("UserId" , "1");
        httpServletRequest.setAttribute("Partner" , "2");
        mockMvc.perform(put("/api/categories/1/transactions?httpServletRequest,transaction")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void shouldDeleteCategoryValidTest() throws Exception{
        MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.setAttribute("UserId" , "1");
        httpServletRequest.setAttribute("Partner" , "2");
        mockMvc.perform(put("/api/categories/1?httpServletRequest")).andDo(print()).andExpect(status().isOk());
    }
}