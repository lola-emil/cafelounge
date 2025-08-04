package com.syntaxerror.cafelounge.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.syntaxerror.cafelounge.model.ProductCategory;

public interface ProductCategoryRepo extends JpaRepository<ProductCategory, Long> {
    
}
