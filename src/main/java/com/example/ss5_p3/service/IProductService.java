package com.example.ss5_p3.service;

import com.example.ss5_p3.model.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product insertProduct(Product product);
}
