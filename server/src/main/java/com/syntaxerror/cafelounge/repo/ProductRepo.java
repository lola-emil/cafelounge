package com.syntaxerror.cafelounge.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.syntaxerror.cafelounge.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {
    
}
