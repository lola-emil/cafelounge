package com.syntaxerror.cafelounge.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.syntaxerror.cafelounge.dto.CheckoutDTO;
import com.syntaxerror.cafelounge.mapper.CheckoutMapper;
import com.syntaxerror.cafelounge.model.Checkout;
import com.syntaxerror.cafelounge.model.PaymentMethod;
import com.syntaxerror.cafelounge.repo.CheckoutRepo;
import com.syntaxerror.cafelounge.repo.PaymentMethodRepo;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/checkout")
public class CheckoutController {

    @Autowired
    CheckoutRepo checkoutRepo;

    @Autowired
    PaymentMethodRepo paymentMethodRepo;

    @GetMapping
    ResponseEntity<List<Checkout>> getCheckoutHistory() {

        List<Checkout> history = checkoutRepo.findAll();

        return ResponseEntity.ok(history);
    }

    @PostMapping
    ResponseEntity<Checkout> addCheckout(@RequestBody @Valid CheckoutDTO checkoutBody) {
        Optional<PaymentMethod> paymentMethod = paymentMethodRepo.findById((long) 1);

        Checkout checkout = CheckoutMapper.toEntity(checkoutBody);

        checkout.setPaymentMethod(paymentMethod.get());

        Checkout newCheckout = checkoutRepo.save(checkout);

        return ResponseEntity.status(HttpStatus.CREATED).body(newCheckout);
    }

    @GetMapping("/{id}")
    ResponseEntity<Checkout> getCheckout(@PathVariable Long id) {
        Optional<Checkout> checkout = checkoutRepo.findById(id);

        if (!checkout.isPresent())
            return ResponseEntity.notFound().build();

        return ResponseEntity.status(HttpStatus.OK).body(checkout.get());
    }
}
