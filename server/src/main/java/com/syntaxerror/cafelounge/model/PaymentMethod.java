package com.syntaxerror.cafelounge.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class PaymentMethod {
    @Id
    Long id;

    String name;
    String description;

    @OneToMany(mappedBy = "paymentMethod", cascade = CascadeType.ALL)
    List<Checkout> checkouts;
}
