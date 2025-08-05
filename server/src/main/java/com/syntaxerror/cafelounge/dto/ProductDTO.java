package com.syntaxerror.cafelounge.dto;

import com.syntaxerror.cafelounge.model.Product;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public class ProductDTO {
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 255, message = "name is only limited to 255 characters")
    private String name;

    private String description;

    @NotNull
    @NotBlank
    @Size(max = 255, message = "sku is only limited to 255 characters")
    private String sku;

    @NotNull
    @PositiveOrZero
    private double unitPrice;

    private boolean isActive;

    @NotNull
    @Valid
    private ProductCategoryDTO productCategory;

    public ProductDTO() {
    }

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.sku = product.getSku();
        this.unitPrice = product.getUnitPrice();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public ProductCategoryDTO getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategoryDTO productCategory) {
        this.productCategory = productCategory;
    }
}
