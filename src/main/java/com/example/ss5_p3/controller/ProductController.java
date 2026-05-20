package com.example.ss5_p3.controller;


import com.example.ss5_p3.model.dto.ApiDataResponse;
import com.example.ss5_p3.model.entity.Product;
import com.example.ss5_p3.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ControllerAdvice
@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final IProductService iProductService;

    @GetMapping
    public ResponseEntity<ApiDataResponse<List<Product>>> getAllProducts() {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Lay data thanh cong",
                iProductService.getAllProducts(),
                HttpStatus.OK
        ), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiDataResponse<Product>> getProductById(@PathVariable Long id) {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "lay du lieu theo " + id + " thanh cong",
                iProductService.getProductById(id),
                HttpStatus.OK
        ),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiDataResponse<Product>> insertProduct(@RequestBody Product product) {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Them data thanh cong",
                iProductService.insertProduct(product),
                HttpStatus.CREATED
        ),HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApiDataResponse<Product>> updateProduct(
            @PathVariable Long id,
            @RequestBody Product product
    ) {

        return new ResponseEntity<>(
                new ApiDataResponse<>(
                        true,
                        "Cap nhat thanh cong",
                        iProductService.updateProduct(id, product),
                        HttpStatus.OK
                ),
                HttpStatus.OK
        );
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiDataResponse<Product>> patchProduct(
            @PathVariable Long id,
            @RequestBody Product product
    ) {

        return new ResponseEntity<>(
                new ApiDataResponse<>(
                        true,
                        "Cap nhat mot phan thanh cong",
                        iProductService.patchProduct(id, product),
                        HttpStatus.OK
                ),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {

        iProductService.deleteProduct(id);

        return ResponseEntity.noContent().build();
    }
}
