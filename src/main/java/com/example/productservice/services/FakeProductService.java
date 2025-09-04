package com.example.productservice.services;

import com.example.productservice.dtos.FakeStoreProductDTO;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeProductService implements  ProductService{

    private RestTemplate restTemplate;

    FakeProductService(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }

    @Override
    public Product getProductByID(long id) {
        FakeStoreProductDTO fakeStoreProductDTO =  restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDTO.class);
        return toProduct(fakeStoreProductDTO);
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(long id, Product product) {
        return null;
    }

    @Override
    public Product deleteProduct(Product product) {
        return null;
    }

    private Product toProduct(FakeStoreProductDTO dto) {
        if (dto == null) {
            return null;
        }

        Product product = new Product();
        product.setId(dto.getId());
        product.setTitle(dto.getTitle());
        product.setPrice(dto.getPrice());
        product.setDesc(dto.getDesc());

        if (dto.getCategory() != null) {
            Category category = new Category();
            category.setId(0L); // you may decide how to assign an ID
            category.setCategory(dto.getCategory());
            product.setCategory(category);
        }
        return product;
    }
}
