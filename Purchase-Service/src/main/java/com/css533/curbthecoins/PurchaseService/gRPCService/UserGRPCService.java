package com.css533.curbthecoins.PurchaseService.gRPCService;

import com.css533.curbthecoins.UserProto;
import com.css533.curbthecoins.UserProtoServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class UserGRPCService {

    @GrpcClient("grpc-user-service")
    UserProtoServiceGrpc.UserProtoServiceBlockingStub userServiceStub;

    public UserProto registerUser(String firstName, String lastName, String email, String password , String inviteCode) {
        UserProto user = UserProto
                .newBuilder()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPassword(password)
                .setInviteCode(inviteCode)
                .build();
        System.out.println("Inside purchase register user service");

            UserProto userResponse = userServiceStub.registerUserProto(user);
            System.out.println("return purchase  register user  service");
            return userResponse;
    }

    public UserProto loginUser(String email, String password){
        UserProto user = UserProto
                .newBuilder()
                .setEmail(email)
                .setPassword(password)
                .build();
        System.out.println("Inside purchase login user service");
            UserProto userResponse = userServiceStub.loginUserProto(user);
            System.out.println("return purchase  login user  service");
            return userResponse;
    }

}
