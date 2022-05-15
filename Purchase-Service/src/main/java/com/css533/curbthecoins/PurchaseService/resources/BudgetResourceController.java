package com.css533.curbthecoins.PurchaseService.resources;


import com.css533.curbthecoins.BudgetProto;
import com.css533.curbthecoins.PurchaseService.gRPCService.BudgetGRPCServices;
import com.google.protobuf.Descriptors;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/api/categories/budget")
@AllArgsConstructor
public class BudgetResourceController {

    @Autowired
    BudgetGRPCServices budgetGRPCServices;

    @CrossOrigin(origins = "*")
    @PostMapping("/budgetSetup")
    public ResponseEntity<Map<Descriptors.FieldDescriptor, Object>> setupBudget(HttpServletRequest request , @RequestBody Map<String , String>  budgetMap){
        Integer userId = Integer.parseInt( request.getAttribute("UserId").toString());
        String title = (String) budgetMap.get("title");
        String description = (String) budgetMap.get("description");
        Double budget = Double.parseDouble(budgetMap.get("budget").toString());
        BudgetProto budgetProto = budgetGRPCServices.createBudget(userId, budget, title, description);

        if(!budgetProto.getHasError()){
            System.out.println(" no error ");
            return new ResponseEntity<>(budgetProto.getAllFields(), HttpStatus.OK);
        }else{
            System.out.println(" error ");
            return new ResponseEntity<>(budgetProto.getAllFields(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Map<Descriptors.FieldDescriptor, Object>> getBudget(HttpServletRequest request){
        int userId = (Integer) request.getAttribute("UserId");
        Integer partnerId = (Integer) request.getAttribute("Partner");
        BudgetProto budgetProto = budgetGRPCServices.fetchBudget(userId, partnerId);
        if(!budgetProto.getHasError()){

            return new ResponseEntity<>(budgetProto.getAllFields(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(budgetProto.getAllFields(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateBudget")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Map<Descriptors.FieldDescriptor, Object>> updateBudget(HttpServletRequest request,
                                                               @RequestBody Map<String , Object>  budgetMap){
        int userId = (Integer) request.getAttribute("UserId");
        Integer partnerId = (Integer) request.getAttribute("Partner");
        String title = (String) budgetMap.get("title");
        String description = (String) budgetMap.get("description");
        Double budget = (Double) budgetMap.get("budget");
        System.out.println("Inside budget edit for user : " + userId);
        BudgetProto budgetProto = budgetGRPCServices.editBudget(userId, partnerId, budget, title, description);
        if(!budgetProto.getHasError()){

            return new ResponseEntity<>(budgetProto.getAllFields(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(budgetProto.getAllFields(), HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping("/updateBudgetPartner")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Map<Descriptors.FieldDescriptor, Object>> updateBudgetPartner(HttpServletRequest request){
        int userId = (Integer) request.getAttribute("UserId");
        Integer partnerId = (Integer) request.getAttribute("Partner");
        System.out.println("Inside budget edit for partner : " + userId);
        BudgetProto budgetProto = budgetGRPCServices.editBudgetPartner(userId, partnerId);
        if(!budgetProto.getHasError()){

            return new ResponseEntity<>(budgetProto.getAllFields(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(budgetProto.getAllFields(), HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/deleteBudget")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Map<Descriptors.FieldDescriptor, Object>> deleteCategory(HttpServletRequest request){
        int userId = (Integer) request.getAttribute("UserId");
        Integer partnerId = (Integer) request.getAttribute("Partner");
        System.out.println("Inside budget edit for partner : " + userId);
        BudgetProto budgetProto = budgetGRPCServices.deleteBudget(userId, partnerId);
        if(!budgetProto.getHasError()){
            System.out.println(" no error "+budgetProto.getAllFields().toString());
            return new ResponseEntity<>(budgetProto.getAllFields(), HttpStatus.OK);
        }else{
            System.out.println(" error "+budgetProto.getAllFields().toString());
            return new ResponseEntity<>(budgetProto.getAllFields(), HttpStatus.BAD_REQUEST);
        }

    }


}
