package com.css533.curbthecoins.PurchaseService.resources;

import com.css533.curbthecoins.PurchaseService.gRPCService.BudgetGRPCServices;
import com.css533.curbthecoins.PurchaseService.gRPCService.UserGRPCService;
import com.css533.curbthecoins.UserProto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserResourceControllerUnitTest {
    private static Map<String, Object> userMap;
    private static UserProto badUserProto;
    private static UserProto userProto;


    @BeforeAll
    public void setup(){
        userMap = new HashMap<>();
        userMap.put("firstName" , "Divya");
        userMap.put("lastName" , "Kamath");
        userMap.put("email" , "dkamath@uw.edu");
        userMap.put("password", "password");
        userMap.put("inviteCode" , "");

        userProto = UserProto
                .newBuilder()
                .setFirstName("Divya")
                .setLastName("Kamath")
                .setEmail("dkamath@uw.edu")
                .setUserId(1)
                .setPartnerId(0)
                .setInviteCode("abcd123")
                .build();

        badUserProto = UserProto
                .newBuilder()
                .setHasError(true)
                .setError("Testing error")
                .build();
    }

    @Test
    void registerUserValidCase(){
        UserGRPCService userServiceGrpc = Mockito.mock(UserGRPCService.class);
        BudgetGRPCServices budgetGRPCServices = Mockito.mock(BudgetGRPCServices.class);
        when(userServiceGrpc.registerUser("Divya","Kamath","dkamath@uw.edu","password","")).thenReturn(userProto);
        UserResourceController userResourceController = new UserResourceController(userServiceGrpc, budgetGRPCServices);
        assertEquals(HttpStatus.OK, userResourceController.registerUser(userMap).getStatusCode());
    }

    @Test
    void registerUserInvalidCase(){
        UserGRPCService userServiceGrpc = Mockito.mock(UserGRPCService.class);
        BudgetGRPCServices budgetGRPCServices = Mockito.mock(BudgetGRPCServices.class);
        when(userServiceGrpc.registerUser("Divya","Kamath","dkamath@uw.edu","password","")).thenReturn(badUserProto);
        UserResourceController userResourceController = new UserResourceController(userServiceGrpc,budgetGRPCServices);
        assertEquals(HttpStatus.BAD_REQUEST, userResourceController.registerUser(userMap).getStatusCode());
    }

    @Test
    void loginUserValidCase(){
        UserGRPCService userServiceGrpc = Mockito.mock(UserGRPCService.class);
        BudgetGRPCServices budgetGRPCServices = Mockito.mock(BudgetGRPCServices.class);
        when(userServiceGrpc.loginUser("dkamath@uw.edu", "password")).thenReturn(userProto);
        UserResourceController userResourceController = new UserResourceController(userServiceGrpc,budgetGRPCServices);
        assertEquals(HttpStatus.OK, userResourceController.loginUser(userMap).getStatusCode());
    }

    @Test
    void loginUserInvalidCase(){
        UserGRPCService userServiceGrpc = Mockito.mock(UserGRPCService.class);
        BudgetGRPCServices budgetGRPCServices = Mockito.mock(BudgetGRPCServices.class);
        when(userServiceGrpc.loginUser("dkamath@uw.edu", "password")).thenReturn(badUserProto);
        UserResourceController userResourceController = new UserResourceController(userServiceGrpc, budgetGRPCServices);
        assertEquals(HttpStatus.BAD_REQUEST, userResourceController.loginUser(userMap).getStatusCode());
    }

}