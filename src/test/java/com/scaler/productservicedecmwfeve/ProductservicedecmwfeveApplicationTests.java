package com.scaler.productservicedecmwfeve;

import com.scaler.productservicedecmwfeve.models.Product;
import com.scaler.productservicedecmwfeve.repositories.ProductRepository;
import com.scaler.productservicedecmwfeve.repositories.projections.ProductWithIdAndTitle;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import java.util.List;

@SpringBootTest
class ProductservicedecmwfeveApplicationTests {
    @Autowired
    private ProductRepository productRepository;
    @Test
    void contextLoads() {
    }

    @Test
    @Transactional
    @Commit
    void testQueries() {
     List<ProductWithIdAndTitle> products = productRepository.someHpaExample();
      for(ProductWithIdAndTitle product : products) {
          System.out.println(product.getId());
          System.out.println(product.getTitle());
          System.out.println(product.getDescription());
      }
    }
}