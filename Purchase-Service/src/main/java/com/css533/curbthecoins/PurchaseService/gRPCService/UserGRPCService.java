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
            System.out.println("2. Inside gRPC user register client. Making a gRPC call to user service from purchase service");
            UserProto userResponse = userServiceStub.registerUserProto(user);
            System.out.println("2. Inside gRPC user register client. Received response from user service to purchase service via gRPC call");
            return userResponse;
    }

    public UserProto loginUser(String email, String password){
        UserProto user = UserProto
                .newBuilder()
                .setEmail(email)
                .setPassword(password)
                .build();
            System.out.println("2. Inside gRPC user login client. Making a gRPC call to user service from purchase service");
            UserProto userResponse = userServiceStub.loginUserProto(user);
            System.out.println("2. Inside gRPC user login client. Received response from user service to purchase service via gRPC call");
            return userResponse;
    }

}
