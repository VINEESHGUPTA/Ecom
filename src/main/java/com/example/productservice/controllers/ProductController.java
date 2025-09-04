package com.example.productservice.controllers;

import com.example.productservice.models.Product;
import com.example.productservice.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    ProductController(ProductService productService){
        this.productService=productService;
    }

    @GetMapping("/{id}")
    public Product getproductById(@PathVariable("id") long id){
        return productService.getProductByID(id);
    }

    @GetMapping
    public List<Product> getAllProducts(@PathVariable("id") long id){
        return new ArrayList<>();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return new Product();
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") long id, @RequestBody Product product){
        return new Product();
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") long id, @RequestBody Product product){
        return new Product();
    }

    @DeleteMapping("/{id}")
    public Product deleteProduct(@PathVariable("id") long id){
        return new Product();
    }


}
