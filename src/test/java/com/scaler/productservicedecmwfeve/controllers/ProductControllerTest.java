package com.scaler.productservicedecmwfeve.controllers;

import com.scaler.productservicedecmwfeve.exceptions.ProductNotExistsException;
import com.scaler.productservicedecmwfeve.models.Product;
import com.scaler.productservicedecmwfeve.repositories.ProductRepository;
import com.scaler.productservicedecmwfeve.services.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {

    @Autowired
    private ProductController productController;

    @MockitoBean
    private ProductService productService = Mockito.mock(ProductService.class);
    @MockitoBean
    private ProductRepository productRepository;

    @Test
    void testProductsSameAsService() {
        //arrange
        List<Product> products = new ArrayList<>();
        Product p1 = new Product();
        p1.setTitle("Iphone 15");
        products.add(p1);

        Product p2 = new Product();
        p2.setTitle("Iphone 17");
        products.add(p2);

        Product p3 = new Product();
        p3.setTitle("Iphone 19");
        products.add(p3);

        when(productService.getAllProducts()).thenReturn(products);
        // act
        ResponseEntity<List<Product>> response = productController.getAllProducts();

        // assert
        List<Product> responseProducts = response.getBody();
        assertEquals(products.size(), responseProducts.size());

        for(int i = 0; i < responseProducts.size(); i++){
            assertEquals(products.get(i).getTitle(),
                    responseProducts.get(i).getTitle());
        }
    }
}