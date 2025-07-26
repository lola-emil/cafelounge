package com.syntaxerror.cafelounge.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.syntaxerror.cafelounge.dto.CheckoutDTO;
import com.syntaxerror.cafelounge.model.Checkout;
import com.syntaxerror.cafelounge.model.CheckoutItem;
import com.syntaxerror.cafelounge.model.PaymentMethod;
import com.syntaxerror.cafelounge.model.Product;

public class CheckoutMapper {

    public static Checkout toEntity(CheckoutDTO dto) {
        Checkout checkout = new Checkout();

        PaymentMethod paymentMethod = new PaymentMethod();

        paymentMethod.setType(dto.getPaymentMethod().getType());
        

        checkout.setPaymentMethod(paymentMethod);

        List<CheckoutItem> items = dto.getCheckoutItems().stream().map(itemDTO -> {
            CheckoutItem item = new CheckoutItem();

            Product product = new Product();

            product.setId(itemDTO.getProduct().getId());

            item.setProduct(product);

            item.setQuantity(itemDTO.getQuantity());

            item.setDiscount(itemDTO.getDiscount());
            item.setUnitPrice(itemDTO.getUnitPrice());
            item.setProductName(itemDTO.getProductName());

            item.setCheckout(checkout);

            return item;
        }).collect(Collectors.toList());

        checkout.setCheckoutItems(items);

        return checkout;
    }
}