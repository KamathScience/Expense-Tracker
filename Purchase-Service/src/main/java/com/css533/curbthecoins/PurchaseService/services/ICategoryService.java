package com.css533.curbthecoins.PurchaseService.services;

import com.css533.curbthecoins.PurchaseService.domain.Category;
import com.css533.curbthecoins.PurchaseService.exceptions.CCBadRequestException;
import com.css533.curbthecoins.PurchaseService.exceptions.CCResourceNotFoundException;

import java.util.List;

public interface ICategoryService {

    List<Category> fetchAllCategories(Integer userId, Integer partnerId);

    Category fetchCategoryById(Integer userId, Integer partnerId, Integer categoryId) throws CCResourceNotFoundException;

    Category addCategory(Integer userId, Integer partnerId, String title, String description) throws CCBadRequestException;

    void updateCategory(Integer userId, Integer partnerId, Integer categoryId, Category category) throws CCBadRequestException;

    void removeCategoryWithAllTransactions(Integer userId, Integer partnerId, Integer categoryId) throws CCResourceNotFoundException;
}
