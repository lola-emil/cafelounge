package com.syntaxerror.cafelounge.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productCode;

    private String name;

    private String description;

    private double price;

    @OneToMany(mappedBy = "product")
    List<ProductStock> productStocks;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdDate = LocalDateTime.now();

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "added_by")
    User user;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<ProductStock> getProductStocks() {
        return productStocks;
    }

    public void setProductStocks(List<ProductStock> productStocks) {
        this.productStocks = productStocks;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
