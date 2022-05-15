package com.css533.curbthecoins.PurchaseService.repositories;

import com.css533.curbthecoins.PurchaseService.domain.Category;
import com.css533.curbthecoins.PurchaseService.exceptions.CCBadRequestException;
import com.css533.curbthecoins.PurchaseService.exceptions.CCResourceNotFoundException;

import java.util.List;

public interface ICategoryRepository {

        List<Category> findAll(Integer userId,  Integer partnerId) throws CCResourceNotFoundException;

        Category findById(Integer userId, Integer partnerId, Integer categoryId) throws CCResourceNotFoundException;

        Integer create(Integer userId, Integer partnerId, String title, String description) throws CCBadRequestException;

        void update(Integer userId, Integer partnerId, Integer categoryId, Category category) throws CCBadRequestException;

        void removeById(Integer userId, Integer partnerId, Integer categoryId);

}
