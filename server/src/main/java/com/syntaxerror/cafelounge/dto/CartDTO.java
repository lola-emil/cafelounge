package com.syntaxerror.cafelounge.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.List;

import com.syntaxerror.cafelounge.model.CartStatus;

public class CartDTO {

    private Long id; // Optional: include only if needed in responses

    @NotBlank(message = "Customer name must not be blank")
    @Size(max = 100, message = "Customer name must be less than 100 characters")
    private String customerName;

    private LocalDateTime createdDate;

    @NotNull(message = "Cart status is required")
    private CartStatus status;

    @NotNull(message = "User ID must not be null")
    private Long userId;

    private CheckoutDTO checkout; // Optional: only if needed

    @NotNull(message = "Cart items must not be null")
    @Size(min = 1, message = "Cart must contain at least one item")
    private List<CartItemDTO> cartItems;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public CartStatus getStatus() {
        return status;
    }

    public void setStatus(CartStatus status) {
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public CheckoutDTO getCheckout() {
        return checkout;
    }

    public void setCheckout(CheckoutDTO checkout) {
        this.checkout = checkout;
    }

    public List<CartItemDTO> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItemDTO> cartItems) {
        this.cartItems = cartItems;
    }
}
