package com.syntaxerror.cafelounge.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.syntaxerror.cafelounge.model.Checkout;

@Repository
public interface CheckoutRepo extends JpaRepository<Checkout, Long> {
    
}
