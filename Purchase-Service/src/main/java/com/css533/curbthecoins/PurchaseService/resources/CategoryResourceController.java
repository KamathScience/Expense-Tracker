package com.css533.curbthecoins.PurchaseService.resources;


import com.css533.curbthecoins.PurchaseService.domain.Category;
import com.css533.curbthecoins.PurchaseService.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/categories")
public class CategoryResourceController {

    @Autowired
    ICategoryService categoryService;

    @GetMapping("")
    @CrossOrigin
    public ResponseEntity<List<Category>> getAllCategories(HttpServletRequest request){
        System.out.println("1. Received request in Purchase service fetch all categories. Forwarding request to category-service-method ");
        int userId = (Integer) request.getAttribute("UserId");
        Integer partnerId = (Integer) request.getAttribute("Partner");
        List<Category> categories = categoryService.fetchAllCategories(userId, partnerId);
        System.out.println("1. Successfully fetched list of categories");
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping("")
    @CrossOrigin
    public ResponseEntity<Category> addCategory (HttpServletRequest request , @RequestBody Map<String , Object> categoryMap){
        System.out.println("1. Received request in Purchase service to add category. Forwarding request to category-service-method ");
        int userId = (Integer) request.getAttribute("UserId");
        Integer partnerId = (Integer) request.getAttribute("Partner");
        String title = (String) categoryMap.get("title");
        String description = (String) categoryMap.get("description");

        System.out.println("Inside add category userID " + userId+" partnerID " + partnerId );
        Category category = categoryService.addCategory(userId,partnerId, title, description);
        System.out.println("1. Successfully created new category");
        return new ResponseEntity<>(category, HttpStatus.CREATED);

    }

    @GetMapping("/{categoryId}")
    @CrossOrigin
    public ResponseEntity<Category> getCategoryById(HttpServletRequest request, @PathVariable("categoryId") Integer categoryId){
        System.out.println("1. Received request in Purchase service to fetch particular category. Forwarding request to category-service-method ");
        int userId = (Integer) request.getAttribute("UserId");
        Integer partnerId = (Integer) request.getAttribute("Partner");
        Category category = categoryService.fetchCategoryById(userId, partnerId, categoryId);
        System.out.println("1. Successfully fetched particular requested category");
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PutMapping("/{categoryId}")
    @CrossOrigin
    public ResponseEntity<Map<String, Boolean>> updateCategory(HttpServletRequest request,
                                                               @PathVariable("categoryId") Integer categoryId,
                                                               @RequestBody Category category){
        System.out.println("1. Received request in Purchase service to update category. Forwarding request to category-service-method ");
        int userId = (Integer) request.getAttribute("UserId");
        Integer partnerId = (Integer) request.getAttribute("Partner");
        categoryService.updateCategory(userId,partnerId, categoryId, category);
        Map<String, Boolean> map = new HashMap<>();
        map.put("Success", true);
        System.out.println("1. Successfully updated the category");
        return new ResponseEntity<>(map, HttpStatus.OK);

    }

    @DeleteMapping("/{categoryId}")
    @CrossOrigin
    public ResponseEntity<Map<String, Boolean>> deleteCategory(HttpServletRequest request,
                                                               @PathVariable("categoryId") Integer categoryId){
        System.out.println("1. Received request in Purchase service to delete particular category. Forwarding request to category-service-method ");
        int userId = (Integer) request.getAttribute("UserId");
        Integer partnerId = (Integer) request.getAttribute("Partner");
        categoryService.removeCategoryWithAllTransactions(userId,partnerId, categoryId);
        Map<String, Boolean> map = new HashMap<>();
        map.put("Success", true);
        System.out.println("1. Successfully deleted the category");
        return new ResponseEntity<>(map, HttpStatus.OK);

    }



}
