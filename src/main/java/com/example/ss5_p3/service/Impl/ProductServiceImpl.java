package com.example.ss5_p3.service.Impl;


import com.example.ss5_p3.model.entity.Product;
import com.example.ss5_p3.repository.IProductRepository;
import com.example.ss5_p3.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {
    private final IProductRepository productRepository;
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product insertProduct(Product product) {
        return productRepository.save(product);
    }
}
