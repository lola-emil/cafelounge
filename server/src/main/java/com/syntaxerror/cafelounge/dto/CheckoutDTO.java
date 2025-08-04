package com.syntaxerror.cafelounge.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.syntaxerror.cafelounge.model.Checkout;

import jakarta.validation.Valid;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class CheckoutDTO {
    private Long id;

    @FutureOrPresent
    private LocalDateTime checkoutTime;

    private double totalAmount;

    private double taxAmount;

    private double discountAmount;

    @NotNull
    @NotBlank
    private String paymentMethod;

    @NotNull
    @NotBlank
    private String cashierName;

    @NotEmpty
    @Valid
    private List<CheckoutItemDTO> items;

    public CheckoutDTO() {
    }

    public CheckoutDTO(Checkout checkout) {
        this.id = checkout.getId();
        this.checkoutTime = checkout.getCheckoutTime();
        this.totalAmount = checkout.getTotalAmount();
        this.taxAmount = checkout.getTaxAmount();
        this.discountAmount = checkout.getDiscountAmount();
        this.paymentMethod = checkout.getPaymentMethod();
        this.cashierName = checkout.getCashierName();
        this.items = checkout.getItems()
                .stream()
                .map(CheckoutItemDTO::new)
                .collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCheckoutTime() {
        return checkoutTime;
    }

    public void setCheckoutTime(LocalDateTime checkoutTime) {
        this.checkoutTime = checkoutTime;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getCashierName() {
        return cashierName;
    }

    public void setCashierName(String cashierName) {
        this.cashierName = cashierName;
    }

    public List<CheckoutItemDTO> getItems() {
        return items;
    }

    public void setItems(List<CheckoutItemDTO> items) {
        this.items = items;
    }

    // Getters and setters
}
