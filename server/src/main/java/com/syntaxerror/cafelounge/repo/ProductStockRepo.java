package com.syntaxerror.cafelounge.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.syntaxerror.cafelounge.model.ProductStock;

public interface ProductStockRepo extends JpaRepository<ProductStock, Long> {
    
}
