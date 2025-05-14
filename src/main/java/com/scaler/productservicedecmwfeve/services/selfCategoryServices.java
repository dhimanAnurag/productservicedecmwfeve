package com.scaler.productservicedecmwfeve.services;

import com.scaler.productservicedecmwfeve.models.Category;
import com.scaler.productservicedecmwfeve.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfCategoryService")
public class selfCategoryServices implements CatergoryService{

    @Autowired
    private CategoryRepository categoryRepository;
    public selfCategoryServices(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
      List<Category> categories = categoryRepository.findAll();
      return categories;
    }
}
