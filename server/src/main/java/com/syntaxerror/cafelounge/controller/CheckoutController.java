package com.syntaxerror.cafelounge.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.syntaxerror.cafelounge.dto.CheckoutDTO;
import com.syntaxerror.cafelounge.mapper.CheckoutMapper;
import com.syntaxerror.cafelounge.model.Checkout;
import com.syntaxerror.cafelounge.repo.CheckoutRepo;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/checkouts")
public class CheckoutController {

    @Autowired
    CheckoutRepo checkoutRepo;

    @GetMapping
    ResponseEntity<List<CheckoutDTO>> getCheckouts() {
        List<CheckoutDTO> checkouts = checkoutRepo.findAll()
                .stream()
                .map(CheckoutMapper::toDTO).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(checkouts);
    }

    @PostMapping
    ResponseEntity<CheckoutDTO> addCheckout(
            @RequestBody @Valid CheckoutDTO checkoutDTO) {
        Checkout checkout = CheckoutMapper.toEntity(checkoutDTO);
        Checkout newCheckout = checkoutRepo.save(checkout);

        return ResponseEntity.status(HttpStatus.CREATED).body(CheckoutMapper.toDTO(newCheckout));
    }
}
