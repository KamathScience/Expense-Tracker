package com.css533.curbthecoins.BudgetService.grpcService;

import com.css533.curbthecoins.BudgetProto;
import com.css533.curbthecoins.BudgetProtoServiceGrpc;
import com.css533.curbthecoins.BudgetService.domain.Budget;
import com.css533.curbthecoins.BudgetService.services.IBudgetService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class gRPCBudgetService extends BudgetProtoServiceGrpc.BudgetProtoServiceImplBase {

    @Autowired
    IBudgetService budgetService;

    @Override
    public void setBudget(BudgetProto request, StreamObserver<BudgetProto> responseObserver) {
        Integer userId = (Integer) request.getUserId();
        Integer partnerId = (Integer) request.getPartnerId();
        String title = (String) request.getTitle();
        String description = (String) request.getDescription();
        Double budget = (Double) request.getBudget();
        System.out.println("Inside set budget ");
        try{
            Budget budgetResponse = budgetService.createBudget(userId, partnerId, budget,title, description);
            BudgetProto response = BudgetProto.newBuilder()
                    .setBudgetId(budgetResponse.getBudgetId())
                    .setUserId(budgetResponse.getUserId())
                    .setPartnerId(budgetResponse.getPartnerId())
                    .setBudget(budgetResponse.getTotalBudget())
                    .setTitle(budgetResponse.getTitle())
                    .setDescription(budgetResponse.getDescription())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }catch(Exception e){
            BudgetProto response = BudgetProto.newBuilder()
                    .setHasError(true)
                    .setError(e.getMessage())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }


    }

    @Override
    public void editBudget(BudgetProto request, StreamObserver<BudgetProto> responseObserver) {
        Integer userId = (Integer) request.getUserId();
        Integer partnerId = (Integer) request.getPartnerId();
        String title = (String) request.getTitle();
        String description = (String) request.getDescription();
        Double budget = (Double) request.getBudget();
        System.out.println("Inside edit budget ");
        try{
             budgetService.updateBudget(userId,partnerId,budget,title,description);
            BudgetProto response = BudgetProto.newBuilder()
                    .setHasError(false)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }catch(Exception e){
            BudgetProto response = BudgetProto.newBuilder()
                    .setHasError(true)
                    .setError(e.getMessage())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void editBudgetPartner(BudgetProto request, StreamObserver<BudgetProto> responseObserver) {
        Integer userId = (Integer) request.getUserId();
        Integer partnerId = (Integer) request.getPartnerId();

        System.out.println("Inside edit budget partner");
        try{
            budgetService.updateBudgetPartner(userId,partnerId);
            BudgetProto response = BudgetProto.newBuilder()
                    .setHasError(false)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }catch(Exception e){
            BudgetProto response = BudgetProto.newBuilder()
                    .setHasError(true)
                    .setError(e.getMessage())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void deleteBudget(BudgetProto request, StreamObserver<BudgetProto> responseObserver) {
        Integer userId = (Integer) request.getUserId();
        Integer partnerId = (Integer) request.getPartnerId();

        System.out.println("Inside delete budget ");
        try{
            budgetService.removeBudgetById(userId , partnerId);
            BudgetProto response = BudgetProto.newBuilder()
                    .setHasError(false)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }catch(Exception e){
            BudgetProto response = BudgetProto.newBuilder()
                    .setHasError(true)
                    .setError(e.getMessage())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
    @Override
    public void readBudget(BudgetProto request, StreamObserver<BudgetProto> responseObserver) {
        Integer userId = (Integer) request.getUserId();
        Integer partnerId = (Integer) request.getPartnerId();

        System.out.println("Inside read budget ");
        try{
            Budget budgetResponse = budgetService.findBudgetById(userId,partnerId);
            BudgetProto response = BudgetProto.newBuilder()
                    .setBudgetId(budgetResponse.getBudgetId())
                    .setUserId(budgetResponse.getUserId())
                    .setPartnerId(budgetResponse.getPartnerId())
                    .setBudget(budgetResponse.getTotalBudget())
                    .setTitle(budgetResponse.getTitle())
                    .setDescription(budgetResponse.getDescription())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }catch(Exception e){
            BudgetProto response = BudgetProto.newBuilder()
                    .setHasError(true)
                    .setError(e.getMessage())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }



}
