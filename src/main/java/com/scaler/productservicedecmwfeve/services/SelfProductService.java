package com.scaler.productservicedecmwfeve.services;

import com.scaler.productservicedecmwfeve.exceptions.ProductNotExistsException;
import com.scaler.productservicedecmwfeve.models.Category;
import com.scaler.productservicedecmwfeve.models.Product;
import com.scaler.productservicedecmwfeve.repositories.CategoryRepository;
import com.scaler.productservicedecmwfeve.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
public class SelfProductService implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public SelfProductService(ProductRepository productRepository,
                              CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getSingleProduct(Long id) throws ProductNotExistsException { // In Class

        Optional<Product> productOptional = productRepository.findById(1L);

        if (productOptional.isEmpty()) {
            throw new ProductNotExistsException("Product with id: " + id + " doesn't exist.");
        }

        Product product = productOptional.get();

        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product updateProduct(Long id, Product product) { // In Class
       Optional<Product> productOptional = productRepository.findById(id);
       if(productOptional.isEmpty()) throw new RuntimeException();
          Product savedProduct = productOptional.get();
         if (product.getTitle() != null) {
             savedProduct.setTitle(product.getTitle());
           }
         if(product.getDescription() != null) {
             savedProduct.setDescription(product.getDescription());
         }
        if(product.getPrice() != null) {
            savedProduct.setPrice(product.getPrice());
        }
        if(product.getImageUrl() != null) {
            savedProduct.setImageUrl(product.getImageUrl());
        }
        return productRepository.save(savedProduct);
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product addNewProduct(Product product) { // In Class

        Optional<Category> categoryOptional = categoryRepository.findByName(product.getCategory().getName());

        if (categoryOptional.isEmpty()) {
            product.setCategory(categoryRepository.save(product.getCategory()));
        } else {
            product.setCategory(categoryOptional.get());
        }

        return productRepository.save(product);
    }

    @Override
    public boolean deleteProduct(Long id) {
        return false;
    }
}
