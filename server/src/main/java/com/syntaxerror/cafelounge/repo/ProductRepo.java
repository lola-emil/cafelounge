
package com.syntaxerror.cafelounge.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.syntaxerror.cafelounge.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    
}