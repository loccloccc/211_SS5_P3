package com.example.ss5_p3.repository;

import com.example.ss5_p3.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IProductRepository extends JpaRepository<Product , Long> {
}
