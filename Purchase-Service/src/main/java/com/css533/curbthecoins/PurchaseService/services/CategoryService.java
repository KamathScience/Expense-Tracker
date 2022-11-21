package com.css533.curbthecoins.PurchaseService.services;

import com.css533.curbthecoins.PurchaseService.domain.Category;
import com.css533.curbthecoins.PurchaseService.exceptions.CCBadRequestException;
import com.css533.curbthecoins.PurchaseService.exceptions.CCResourceNotFoundException;
import com.css533.curbthecoins.PurchaseService.repositories.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional

public class CategoryService implements ICategoryService{

    @Autowired
    ICategoryRepository categoryRepository;

    @Override
    public List<Category> fetchAllCategories(Integer userId, Integer partnerId) {
        System.out.println("2. Received fetch all categories request, forwarding the request to category repository");
        return  categoryRepository.findAll(userId, partnerId);
    }

    @Override
    public Category fetchCategoryById(Integer userId,  Integer partnerId, Integer categoryId) throws CCResourceNotFoundException {
        System.out.println("2. Received fetch particular category request, forwarding the request to category repository");
        return categoryRepository.findById(userId, partnerId, categoryId);
    }

    @Override
    public Category addCategory(Integer userId, Integer partnerId, String title, String description) throws CCBadRequestException {
        System.out.println("2. Received add category request, forwarding the request to category repository");
        int categoryId = categoryRepository.create(userId,partnerId, title, description);
        return categoryRepository.findById(userId,partnerId, categoryId);
    }

    @Override
    public void updateCategory(Integer userId,  Integer partnerId, Integer categoryId, Category category) throws CCBadRequestException {
        System.out.println("2. Received update category request, forwarding the request to category repository");
        categoryRepository.update(userId,partnerId, categoryId, category);
    }

    @Override
    public void removeCategoryWithAllTransactions(Integer userId,  Integer partnerId, Integer categoryId) throws CCResourceNotFoundException {
        System.out.println("2. Received request to delete category, forwarding the request to category repository");
        this.fetchCategoryById(userId,partnerId,categoryId);
        categoryRepository.removeById(userId,partnerId, categoryId);
    }
}
