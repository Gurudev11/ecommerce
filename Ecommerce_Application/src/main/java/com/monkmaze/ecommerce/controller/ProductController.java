package com.monkmaze.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monkmaze.ecommerce.entity.Product;
import com.monkmaze.ecommerce.repository.ProductRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/api")
@Tag(name= "Product Management", description = "Operations related to product management")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/products")
    @Operation(summary = "Add a new product", description  = "This endpoint allows you to add a new product to the database")
    public Product addProduct(@RequestBody Product product) {
        productRepository.save(product);
        return product;
    }

    @GetMapping("/products")
    @Operation(summary  = "Get all products", description = "This endpoint retrieves all the products in the database")
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }
}
