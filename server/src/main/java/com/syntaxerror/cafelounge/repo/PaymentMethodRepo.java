package com.syntaxerror.cafelounge.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.syntaxerror.cafelounge.model.PaymentMethod;

public interface PaymentMethodRepo extends JpaRepository<PaymentMethod, Long> {

}
