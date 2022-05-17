package com.css533.curbthecoins.PurchaseService.resources;

import com.css533.curbthecoins.PurchaseService.Constants;
import com.css533.curbthecoins.PurchaseService.gRPCService.UserGRPCService;
import com.css533.curbthecoins.UserProto;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserResourceController {

    @Autowired
    UserGRPCService userServiceGrpc;

    public UserResourceController() {

    }

    @CrossOrigin(origins = "*")
    @PostMapping("/register")
    public ResponseEntity< Map<String, String>> registerUser(@RequestBody Map<String, Object> userMap){
        String firstName = (String) userMap.get("firstName");
        String lastName = (String) userMap.get("lastName");
        String email = (String) userMap.get("email");
        String password = (String) userMap.get("password");
        String inviteCode = (String) userMap.get("inviteCode");
        System.out.println("Inside purchase register user resource for user : " + firstName);
        UserProto user = userServiceGrpc.registerUser(firstName, lastName, email, password, inviteCode) ;
        if(!user.getHasError()){
            return new ResponseEntity<>(generateJWTToken(user), HttpStatus.OK);
        }else{
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("error" , user.getError());
            return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> loginUser(@RequestBody Map<String,Object> userMap){
        String email = (String) userMap.get("email");
        String password = (String) userMap.get("password");
        System.out.println("Inside purchase login user resource for user : " + email);
        UserProto user = userServiceGrpc.loginUser(email, password);
        if(!user.getHasError()){
            return new ResponseEntity<>(generateJWTToken(user), HttpStatus.OK);
        }else{
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("error" , user.getError());
            return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
        }
    }

    private Map<String, String> generateJWTToken(UserProto user){

        long timestamp = System.currentTimeMillis();

        String token = Jwts.builder().signWith( SignatureAlgorithm.HS256 , Constants.API_SECRET_KEY)
                .setIssuedAt(new Date(timestamp) )
                .setExpiration(new Date(timestamp + Constants.TOKEN_VALIDITY))
                .claim("UserId", user.getUserId())
                .claim("FirstName" , user.getFirstName())
                .claim("LastName" , user.getLastName())
                .claim("Email" , user.getEmail())
                .claim("Partner", user.getPartnerId())
                .compact();
        System.out.println(user.getPartnerId() + " inside generate JWT Token ");
        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        map.put("userName", user.getFirstName() +" "+ user.getLastName());
        map.put("userId", user.getUserId() +"");
        map.put("invite_code", user.getInviteCode());
        map.put("partnerId", user.getPartnerId()+"");
        return map;
    }

}
