package com.syntaxerror.cafelounge.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.syntaxerror.cafelounge.model.Cart;

public interface CartRepo extends JpaRepository<Cart, Long> {
    
}
