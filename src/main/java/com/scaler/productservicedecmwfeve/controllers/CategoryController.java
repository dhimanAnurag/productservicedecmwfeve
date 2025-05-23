package com.scaler.productservicedecmwfeve.controllers;
import com.scaler.productservicedecmwfeve.exceptions.CategoryNotExistsException;
import com.scaler.productservicedecmwfeve.models.Category;
import com.scaler.productservicedecmwfeve.repositories.CategoryRepository;
import com.scaler.productservicedecmwfeve.services.CatergoryService;
import com.scaler.productservicedecmwfeve.services.selfCategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private CatergoryService catergoryService;
    @Autowired
    public CategoryController(@Qualifier("selfCategoryService") CatergoryService catergoryService) {
      this.catergoryService = catergoryService;
    }

    @GetMapping()
    public ResponseEntity<List<Category>> getAllCategories() {
      ResponseEntity<List<Category>> response = new ResponseEntity<>(catergoryService.getAllCategories(), HttpStatus.OK);
      return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") long id) throws CategoryNotExistsException {
        return new ResponseEntity<>(catergoryService.getCategoryById(id), HttpStatus.OK);
    }

    @PostMapping()
    public Category addNewCategory(@RequestBody Category category) {
        return catergoryService.addNewCategory(category);
    }
}
