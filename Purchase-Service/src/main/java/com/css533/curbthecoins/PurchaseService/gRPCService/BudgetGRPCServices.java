package com.css533.curbthecoins.PurchaseService.gRPCService;

import com.css533.curbthecoins.BudgetProto;
import com.css533.curbthecoins.BudgetProtoServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class BudgetGRPCServices {

    @GrpcClient("grpc-budget-service")
    BudgetProtoServiceGrpc.BudgetProtoServiceBlockingStub budgetServiceStub;

    public BudgetProto createBudget(Integer userId, Integer partnerId, Double budget, String title, String description) {
        BudgetProto budgetProto = BudgetProto
                .newBuilder()
                .setUserId(userId)
                .setPartnerId(partnerId)
                .setBudget(budget)
                .setTitle(title)
                .setDescription(description)
                .build();
        System.out.println("2. Inside gRPC budget client. Making a gRPC call to budget service from purchase service to setup budget");
        BudgetProto budgetProtoResponse = budgetServiceStub.setBudget(budgetProto);
        System.out.println("2. Inside gRPC budget client. Received response from budget service to purchase service via gRPC call");
        return budgetProtoResponse;
    }

    public BudgetProto fetchBudget(Integer userId, Integer partnerId){
        BudgetProto budgetProto = BudgetProto
                .newBuilder()
                .setUserId(userId)
                .setPartnerId(partnerId)
                .build();
        System.out.println("2. Inside gRPC budget client. Making a gRPC call to budget service from purchase service to fetch budget");
        BudgetProto budgetProtoResponse = budgetServiceStub.readBudget(budgetProto);
        System.out.println("2. Inside gRPC budget client. Received response from budget service to purchase service via gRPC call");
        return budgetProtoResponse;
    }


    public BudgetProto editBudgetPartner(Integer userId,Integer partnerId) {
        BudgetProto budgetProto = BudgetProto
                .newBuilder()
                .setUserId(userId)
                .setPartnerId(partnerId)
                .build();
        System.out.println("2. Inside gRPC budget client. Making a gRPC call to budget service from purchase service to update budget partner");
        BudgetProto budgetProtoResponse = budgetServiceStub.editBudgetPartner(budgetProto);
        System.out.println("2. Inside gRPC budget client. Received response from budget service to purchase service via gRPC call");
        return budgetProtoResponse;
    }

    //    public BudgetProto editBudget(Integer userId,Integer partnerId, Double budget, String title, String description) {
//        BudgetProto budgetProto = BudgetProto
//                .newBuilder()
//                .setUserId(userId)
//                .setPartnerId(partnerId)
//                .setBudget(budget)
//                .setTitle(title)
//                .setDescription(description)
//                .build();
//        System.out.println("Inside budget edit grpc budget service");
//
//        BudgetProto budgetProtoResponse = budgetServiceStub.editBudget(budgetProto);
//        System.out.println("return from budget edit grpc budget service");
//        return budgetProtoResponse;
//    }

//    public BudgetProto deleteBudget(Integer userId,Integer partnerId) {
//        BudgetProto budgetProto = BudgetProto
//                .newBuilder()
//                .setUserId(userId)
//                .setPartnerId(partnerId)
//                .build();
//        System.out.println("Inside budget delete grpc budget service");
//
//        BudgetProto budgetProtoResponse = budgetServiceStub.deleteBudget(budgetProto);
//        System.out.println("return from budget delete grpc budget service");
//        return budgetProtoResponse;
//    }
}
