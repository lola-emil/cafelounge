package com.syntaxerror.cafelounge.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.syntaxerror.cafelounge.model.ProductStockHistory;

public interface ProductStockHistoryRepo extends JpaRepository<ProductStockHistory, Long> {
    
}
