package com.syntaxerror.cafelounge.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.syntaxerror.cafelounge.model.CartItem;

public interface CartItemRepo extends JpaRepository<CartItem, Long> {
    
}
