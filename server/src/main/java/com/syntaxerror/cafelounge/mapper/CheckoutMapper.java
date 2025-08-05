package com.syntaxerror.cafelounge.mapper;

import java.util.stream.Collectors;

import com.syntaxerror.cafelounge.dto.CheckoutDTO;
import com.syntaxerror.cafelounge.model.Checkout;

public class CheckoutMapper {

    public static CheckoutDTO toDTO(Checkout checkout) {
        CheckoutDTO checkoutDTO = new CheckoutDTO();

        checkoutDTO.setId(checkout.getId());
        checkoutDTO.setCheckoutTime(checkout.getCheckoutTime());
        checkoutDTO.setTotalAmount(checkout.getTotalAmount());
        checkoutDTO.setTaxAmount(checkout.getTaxAmount());
        checkoutDTO.setDiscountAmount(checkout.getDiscountAmount());
        checkoutDTO.setPaymentMethod(checkout.getPaymentMethod());
        checkoutDTO.setCashierName(checkout.getCashierName());
        checkoutDTO.setItems(checkout.getItems().stream().map(CheckoutItemMapper::toDTO)
                .collect(Collectors.toList()));

        return checkoutDTO;
    }

    public static Checkout toEntity(CheckoutDTO checkoutDTO) {
        Checkout checkout = new Checkout();

        checkout.setId(checkoutDTO.getId());
        checkout.setCheckoutTime(checkoutDTO.getCheckoutTime());
        checkout.setTotalAmount(checkoutDTO.getTotalAmount());
        checkout.setTaxAmount(checkoutDTO.getTaxAmount());
        checkout.setDiscountAmount(checkoutDTO.getDiscountAmount());
        checkout.setPaymentMethod(checkoutDTO.getPaymentMethod());
        checkout.setCashierName(checkoutDTO.getCashierName());
        checkout.setItems(checkoutDTO.getItems().stream().map(CheckoutItemMapper::toEntity)
                .collect(Collectors.toList()));

        return checkout;
    }
}