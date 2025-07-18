package com.syntaxerror.cafelounge.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.syntaxerror.cafelounge.model.Checkout;

public interface CheckoutRepo extends JpaRepository<Checkout, Long>  {
    
}
