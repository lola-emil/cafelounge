package com.syntaxerror.cafelounge.controller;

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
import com.syntaxerror.cafelounge.model.Checkout;
import com.syntaxerror.cafelounge.repo.CheckoutRepo;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/checkout")
public class CheckoutController {
    
    @Autowired
    CheckoutRepo checkoutRepo;

    @PostMapping
    ResponseEntity<Checkout> addCheckout(@RequestBody @Valid CheckoutDTO checkoutBody) {
        Checkout checkout = new Checkout();

        // TODO: build ang checkout

        return ResponseEntity.status(HttpStatus.CREATED).body(checkout);
    }

    @GetMapping("/{id}")
    ResponseEntity<Checkout> getCheckout(@PathVariable Long id) {
        Optional<Checkout> checkout = checkoutRepo.findById(id);

        if (!checkout.isPresent())
            return ResponseEntity.notFound().build();

        return ResponseEntity.status(HttpStatus.OK).body(checkout.get());
    }
}
