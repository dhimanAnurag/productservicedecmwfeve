package com.scaler.productservicedecmwfeve.services;

import com.scaler.productservicedecmwfeve.exceptions.CategoryNotExistsException;
import com.scaler.productservicedecmwfeve.models.Category;

import java.util.List;

public interface CatergoryService {
    List<Category> getAllCategories();
    Category getCategoryById(Long id) throws CategoryNotExistsException;
}
