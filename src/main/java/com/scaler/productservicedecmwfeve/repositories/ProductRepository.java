package com.scaler.productservicedecmwfeve.repositories;

import com.scaler.productservicedecmwfeve.models.Category;
import com.scaler.productservicedecmwfeve.models.Product;
import com.scaler.productservicedecmwfeve.repositories.projections.ProductWithIdAndTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNullApi;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository
    extends JpaRepository<Product, Long> {

    Optional<Product> findById(Long id);
    // this will return a null ifno product matches the id

    @Query("Select p.id as id , p.title as title, p.description as description from Product p where p.id = 2")
     List<ProductWithIdAndTitle> someHpaExample();
    Product save(Product product);
}

// 1. CategoryRepository.findById()
// 2. ProductRepository.findByCategory()
// Problem: API may be a bit slower because 2 DB Calls