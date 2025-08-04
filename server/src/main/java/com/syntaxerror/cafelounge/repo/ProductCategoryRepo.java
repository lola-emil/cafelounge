package com.syntaxerror.cafelounge.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.syntaxerror.cafelounge.model.ProductCategory;

@Repository
public interface ProductCategoryRepo extends JpaRepository<ProductCategory, Long> {
    Optional<ProductCategory> findByName(String name);
}
