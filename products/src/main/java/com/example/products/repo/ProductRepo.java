package com.example.products.repo;

import com.example.products.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository


public interface ProductRepo extends JpaRepository<Product, Integer> {

}

