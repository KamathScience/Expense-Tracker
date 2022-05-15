package com.css533.curbthecoins.UserService.grpcService;

import com.css533.curbthecoins.UserProto;
import com.css533.curbthecoins.UserProtoServiceGrpc;
import com.css533.curbthecoins.UserService.domain.User;
import com.css533.curbthecoins.UserService.services.IUserService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class GrpcUserService extends UserProtoServiceGrpc.UserProtoServiceImplBase {

    @Autowired
    IUserService userService;


    @Override
    public void registerUserProto(UserProto request, StreamObserver<UserProto> responseObserver) {
        String firstName = (String) request.getFirstName();
        String lastName = (String) request.getLastName();
        String email = (String) request.getEmail();
        String password = (String) request.getPassword();
        String inviteCode = (String) request.getInviteCode();
        try {
            User user = userService.registerUser(firstName, lastName, email, password, inviteCode);
            UserProto response = UserProto.newBuilder()
                    .setUserId(user.getUserId())
                    .setFirstName(user.getFirstName())
                    .setLastName(user.getLastName())
                    .setEmail(user.getEmail())
                    .setPartnerId(user.getPartnerId())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }catch(Exception e){
            UserProto response = UserProto.newBuilder()
                    .setHasError(true)
                    .setError(e.getMessage())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
    }
    }

    @Override
    public void loginUserProto(UserProto request, StreamObserver<UserProto> responseObserver) {
        String email = (String) request.getEmail();
        String password = (String) request.getPassword();
        try{
            User user = userService.validateUser(email, password);
            System.out.println("user.userid" + user.getUserId());
            UserProto response = UserProto.newBuilder()
                    .setEmail(user.getEmail())
                    .setFirstName(user.getFirstName())
                    .setLastName(user.getLastName())
                    .setUserId(user.getUserId())
                    .setPartnerId(user.getPartnerId())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }catch(Exception e){
            UserProto response = UserProto.newBuilder()
                    .setHasError(true)
                    .setError(e.getMessage())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}
