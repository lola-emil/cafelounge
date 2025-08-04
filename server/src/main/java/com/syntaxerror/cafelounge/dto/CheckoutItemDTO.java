package com.syntaxerror.cafelounge.dto;

import com.syntaxerror.cafelounge.model.Checkout;
import com.syntaxerror.cafelounge.model.CheckoutItem;
import com.syntaxerror.cafelounge.model.Product;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public class CheckoutItemDTO {
    private Long id;

    @NotNull
    @Valid
    private Checkout checkout;

    @NotNull
    @Valid
    private Product product;

    @NotNull
    @Positive
    private int quantity;

    @NotNull
    @PositiveOrZero
    private double unitPrice;

    @NotNull
    private double totalPrice;

    public CheckoutItemDTO() {
    }

    public CheckoutItemDTO(CheckoutItem item) {
        this.id = item.getId();
        this.checkout = item.getCheckout();
        this.quantity = item.getQuantity();
        this.unitPrice = item.getUnitPrice();
        this.totalPrice = item.getTotalPrice();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Checkout getCheckout() {
        return checkout;
    }

    public void setCheckout(Checkout checkout) {
        this.checkout = checkout;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    // Getters and setters
}
