package com.syntaxerror.cafelounge.dto;

import java.util.List;

public class PaymentMethodDTO {
    Long id;

    String name;
    String description;

    List<CheckoutDTO> checkouts;
}
