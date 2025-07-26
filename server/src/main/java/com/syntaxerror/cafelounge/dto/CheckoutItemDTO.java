package com.syntaxerror.cafelounge.dto;

import jakarta.validation.constraints.*;

public class CheckoutItemDTO {

    private Long id;

    @NotNull(message = "Product must not be null")
    private ProductDTO product;

    // @Min(value = 1, message = "Quantity must be at least 1")
    private int quantity;

    // @DecimalMin(value = "0.0", inclusive = true, message = "Discount cannot be negative")
    private double discount;

    // @DecimalMin(value = "0.0", inclusive = true, message = "Unit price cannot be negative")
    private double unitPrice;

    // @NotBlank(message = "Product name must not be blank")
    // @Size(max = 255, message = "Product name must be at most 255 characters")
    private String productName;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
