package com.css533.curbthecoins.PurchaseService.resources;

import com.css533.curbthecoins.BudgetProto;
import com.css533.curbthecoins.PurchaseService.gRPCService.BudgetGRPCServices;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletRequest;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BudgetResourceControllerUnitTest {
    private MockHttpServletRequest httpServletRequest;
    private Map<String, String> budgetMap;
    private Map<String, Object> budgetObjectMap;
    BudgetProto budgetProtoValid;
    BudgetProto budgetProtoInvalid;

    @BeforeAll
    public void setup(){
        httpServletRequest = new MockHttpServletRequest();
        httpServletRequest.setAttribute("UserId" , "1");
        httpServletRequest.setAttribute("Partner" , "2");

        budgetMap = new HashMap<>();
        budgetMap.put("budget" , "10000.00");
        budgetMap.put("title" , "title");
        budgetMap.put("description" , "description");

        budgetObjectMap = new HashMap<>();
        budgetObjectMap.put("budget" , "10000.00");
        budgetObjectMap.put("title" , "title");
        budgetObjectMap.put("description" , "description");

        budgetProtoValid = BudgetProto.newBuilder()
                .setHasError(false)
                .setBudgetId(1)
                .setPartnerId(1)
                .setBudget(100.00)
                .setTitle("title")
                .setHasError(false)
                .build();

        budgetProtoInvalid = BudgetProto.newBuilder()
                .setBudgetId(1)
                .setPartnerId(1)
                .setBudget(100.00)
                .setTitle("title")
                .setHasError(true)
                .setError("Testing error")
                .build();
    }

    @Test
    void setupBudgetInvalidTest(){
        BudgetGRPCServices budgetGRPCServices = Mockito.mock(BudgetGRPCServices.class);
        when(budgetGRPCServices.createBudget(1,1000.00,"title","description")).thenReturn(budgetProtoInvalid);
        BudgetResourceController budgetResourceController = new BudgetResourceController(budgetGRPCServices);
        assertEquals(HttpStatus.BAD_REQUEST, budgetResourceController.setupBudget(httpServletRequest,budgetMap).getStatusCode());
    }

    @Test
    void setupBudgetTest(){
        BudgetGRPCServices budgetGRPCServices = Mockito.mock(BudgetGRPCServices.class);
        when(budgetGRPCServices.createBudget(1,1000.00,"title","description")).thenReturn(budgetProtoValid);
        BudgetResourceController budgetResourceController = new BudgetResourceController(budgetGRPCServices);
        assertEquals(HttpStatus.OK, budgetResourceController.setupBudget(httpServletRequest,budgetMap).getStatusCode());
    }
    @Test
    void getBudgetInvalidTest(){
        BudgetGRPCServices budgetGRPCServices = Mockito.mock(BudgetGRPCServices.class);
        when(budgetGRPCServices.fetchBudget(1,2)).thenReturn(budgetProtoInvalid);
        BudgetResourceController budgetResourceController = new BudgetResourceController(budgetGRPCServices);
        assertEquals(HttpStatus.BAD_REQUEST, budgetResourceController.getBudget(httpServletRequest).getStatusCode());
    }

    @Test
    void getBudgetTest(){
        BudgetGRPCServices budgetGRPCServices = Mockito.mock(BudgetGRPCServices.class);
        when(budgetGRPCServices.fetchBudget(1,2)).thenReturn(budgetProtoValid);
        BudgetResourceController budgetResourceController = new BudgetResourceController(budgetGRPCServices);
        assertEquals(HttpStatus.OK, budgetResourceController.getBudget(httpServletRequest).getStatusCode());
    }
    @Test
    void updateBudgetInvalidTest(){
        BudgetGRPCServices budgetGRPCServices = Mockito.mock(BudgetGRPCServices.class);
        when(budgetGRPCServices.editBudget(1,2,100.00,"title","description")).thenReturn(budgetProtoInvalid);
        BudgetResourceController budgetResourceController = new BudgetResourceController(budgetGRPCServices);
        assertEquals(HttpStatus.BAD_REQUEST, budgetResourceController.updateBudget(httpServletRequest,budgetObjectMap).getStatusCode());
    }

    @Test
    void updateBudgetTest(){
        BudgetGRPCServices budgetGRPCServices = Mockito.mock(BudgetGRPCServices.class);
        when(budgetGRPCServices.editBudget(1,2,100.00,"title","description")).thenReturn(budgetProtoValid);
        BudgetResourceController budgetResourceController = new BudgetResourceController(budgetGRPCServices);
        assertEquals(HttpStatus.OK, budgetResourceController.updateBudget(httpServletRequest,budgetObjectMap).getStatusCode());
    }
    @Test
    void updatePartnerBudgetInvalidTest(){
        BudgetGRPCServices budgetGRPCServices = Mockito.mock(BudgetGRPCServices.class);
        when(budgetGRPCServices.editBudgetPartner(1,2)).thenReturn(budgetProtoInvalid);
        BudgetResourceController budgetResourceController = new BudgetResourceController(budgetGRPCServices);
        assertEquals(HttpStatus.BAD_REQUEST, budgetResourceController.updateBudgetPartner(httpServletRequest).getStatusCode());
    }

    @Test
    void updatePartnerBudgetTest(){
        BudgetGRPCServices budgetGRPCServices = Mockito.mock(BudgetGRPCServices.class);
        when(budgetGRPCServices.editBudgetPartner(1,2)).thenReturn(budgetProtoValid);
        BudgetResourceController budgetResourceController = new BudgetResourceController(budgetGRPCServices);
        assertEquals(HttpStatus.OK, budgetResourceController.updateBudgetPartner(httpServletRequest).getStatusCode());
    }
    @Test
    void deleteBudgetInvalidTest(){
        BudgetGRPCServices budgetGRPCServices = Mockito.mock(BudgetGRPCServices.class);
        when(budgetGRPCServices.deleteBudget(1,1)).thenReturn(budgetProtoInvalid);
        BudgetResourceController budgetResourceController = new BudgetResourceController(budgetGRPCServices);
        assertEquals(HttpStatus.BAD_REQUEST, budgetResourceController.deleteBudget(httpServletRequest).getStatusCode());
    }

    @Test
    void deleteBudgetTest(){
        BudgetGRPCServices budgetGRPCServices = Mockito.mock(BudgetGRPCServices.class);
        when(budgetGRPCServices.deleteBudget(1,1)).thenReturn(budgetProtoValid);
        BudgetResourceController budgetResourceController = new BudgetResourceController(budgetGRPCServices);
        assertEquals(HttpStatus.OK, budgetResourceController.deleteBudget(httpServletRequest).getStatusCode());
    }




}