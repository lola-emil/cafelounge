package com.syntaxerror.cafelounge.dto;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public class CheckoutDTO {
    private Long id;

    @NotNull
    @Valid
    private PaymentMethodDTO paymentMethod;

    @NotNull
    @Valid
    private List<CheckoutItemDTO> checkoutItems;

    private UserDTO cashier;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PaymentMethodDTO getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethodDTO paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public List<CheckoutItemDTO> getCheckoutItems() {
        return checkoutItems;
    }

    public void setCheckoutItems(List<CheckoutItemDTO> checkoutItems) {
        this.checkoutItems = checkoutItems;
    }

    public UserDTO getCashier() {
        return cashier;
    }

    public void setCashier(UserDTO cashier) {
        this.cashier = cashier;
    }
}
