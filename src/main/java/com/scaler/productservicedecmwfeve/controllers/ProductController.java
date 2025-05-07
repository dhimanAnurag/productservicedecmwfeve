package com.scaler.productservicedecmwfeve.controllers;

import com.scaler.productservicedecmwfeve.exceptions.ProductNotExistsException;
import com.scaler.productservicedecmwfeve.models.Product;
import com.scaler.productservicedecmwfeve.services.ProductService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    private RestTemplate restTemplate;

    @Autowired
    public ProductController(@Qualifier("selfProductService") ProductService productService, RestTemplate restTemplate) {
        this.productService = productService;
        this.restTemplate = restTemplate;
    }

    @GetMapping() // localhost:8080/products
    public ResponseEntity<List<Product>> getAllProducts() {
        ResponseEntity<List<Product>> response = new ResponseEntity<>(
                productService.getAllProducts(), HttpStatus.FORBIDDEN
        );
       return response;
    }

    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") Long id) throws ProductNotExistsException {
//        throw new RuntimeException("SOmething went wrong");
//        try {
        return new ResponseEntity<>(
                productService.getSingleProduct(id),
                HttpStatus.OK
        );
//        } catch (ArithmeticException exception) {
//            ResponseEntity<Product> response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
//            return response;
//        } catch (ArrayIndexOutOfBoundsException exception) {
//
//        }

    }


    @PostMapping()
    public Product addNewProduct(@RequestBody Product product) {
        Product p = new Product();
        p.setTitle("A new product");
        return p;
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return new Product();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> replaceProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        ResponseEntity<Product> response = new ResponseEntity<>(
                productService.replaceProduct(id, product), HttpStatus.OK
        );
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}