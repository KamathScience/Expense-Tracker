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
    public ResponseEntity<List<Category>> getAllCategories(HttpServletRequest request){
        int userId = (Integer) request.getAttribute("UserId");
        Integer partnerId = (Integer) request.getAttribute("Partner");
        List<Category> categories = categoryService.fetchAllCategories(userId, partnerId);
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Category> addCategory (HttpServletRequest request , @RequestBody Map<String , Object> categoryMap){
        int userId = (Integer) request.getAttribute("UserId");
        Integer partnerId = (Integer) request.getAttribute("Partner");
        String title = (String) categoryMap.get("title");
        String description = (String) categoryMap.get("description");

        System.out.println("Inside add category userID " + userId+" partnerID " + partnerId );
        Category category = categoryService.addCategory(userId,partnerId, title, description);
        return new ResponseEntity<>(category, HttpStatus.CREATED);

    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<Category> getCategoryById(HttpServletRequest request, @PathVariable("categoryId") Integer categoryId){
        int userId = (Integer) request.getAttribute("UserId");
        Integer partnerId = (Integer) request.getAttribute("Partner");
        Category category = categoryService.fetchCategoryById(userId, partnerId, categoryId);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<Map<String, Boolean>> updateCategory(HttpServletRequest request,
                                                               @PathVariable("categoryId") Integer categoryId,
                                                               @RequestBody Category category){
        int userId = (Integer) request.getAttribute("UserId");
        Integer partnerId = (Integer) request.getAttribute("Partner");
        categoryService.updateCategory(userId,partnerId, categoryId, category);
        Map<String, Boolean> map = new HashMap<>();
        map.put("Success", true);
        return new ResponseEntity<>(map, HttpStatus.OK);

    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<Map<String, Boolean>> deleteCategory(HttpServletRequest request,
                                                               @PathVariable("categoryId") Integer categoryId){
        int userId = (Integer) request.getAttribute("UserId");
        Integer partnerId = (Integer) request.getAttribute("Partner");
        categoryService.removeCategoryWithAllTransactions(userId,partnerId, categoryId);
        Map<String, Boolean> map = new HashMap<>();
        map.put("Success", true);
        return new ResponseEntity<>(map, HttpStatus.OK);

    }



}
