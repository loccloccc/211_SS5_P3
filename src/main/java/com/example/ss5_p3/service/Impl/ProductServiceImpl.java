package com.example.ss5_p3.service.Impl;


import com.example.ss5_p3.model.entity.Product;
import com.example.ss5_p3.repository.IProductRepository;
import com.example.ss5_p3.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    @Override
    public Product updateProduct(Long id, Product product) {

        Product oldProduct = productRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Khong tim thay product"
                        )
                );

        if (product.getName() == null || product.getPrice() == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Name va price khong duoc de trong"
            );
        }

        oldProduct.setName(product.getName());
        oldProduct.setPrice(product.getPrice());

        return productRepository.save(oldProduct);
    }

    @Override
    public Product patchProduct(Long id, Product product) {

        Product oldProduct = productRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Khong tim thay product"
                        )
                );

        if (product.getName() != null) {
            oldProduct.setName(product.getName());
        }

        if (product.getPrice() != null) {
            oldProduct.setPrice(product.getPrice());
        }

        return productRepository.save(oldProduct);
    }

    @Override
    public void deleteProduct(Long id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Khong tim thay product"
                        )
                );

        productRepository.delete(product);
    }
}
