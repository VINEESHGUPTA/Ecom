package com.example.productservice.services;

import com.example.productservice.models.Product;

import java.util.List;

public interface ProductService {

    Product getProductByID(long id);

    List<Product> getAllProducts();

    Product createProduct(Product product);

    Product updateProduct(Product product);

    Product replaceProduct(long id, Product product);

    Product deleteProduct(Product product);
}
