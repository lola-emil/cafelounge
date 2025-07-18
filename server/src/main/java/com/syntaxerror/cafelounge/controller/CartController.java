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

import com.syntaxerror.cafelounge.dto.CartDTO;
import com.syntaxerror.cafelounge.model.Cart;
import com.syntaxerror.cafelounge.repo.CartRepo;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    CartRepo cartRepo;
    
    @GetMapping("/{id}")
    ResponseEntity<Cart> getCart(@PathVariable Long id) {
        Optional<Cart> cart = cartRepo.findById(id); 

        if (!cart.isPresent())
            return ResponseEntity.notFound().build();

        return ResponseEntity.status(HttpStatus.OK).body(cart.get());
    }

    @PostMapping
    ResponseEntity<Cart> addCart(@RequestBody @Valid CartDTO cartBody) {
        Cart cart = new Cart();


        // TODO: build ang cart

        Cart newCart = cartRepo.save(cart);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCart);
    }
}
