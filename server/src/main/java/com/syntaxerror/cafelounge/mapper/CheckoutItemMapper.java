package com.syntaxerror.cafelounge.mapper;

import com.syntaxerror.cafelounge.dto.CheckoutItemDTO;
import com.syntaxerror.cafelounge.model.CheckoutItem;

public class CheckoutItemMapper {

    public static CheckoutItem toEntity(CheckoutItemDTO checkoutItemDTO) {
        CheckoutItem checkoutItem = new CheckoutItem();

        checkoutItem.setId(checkoutItemDTO.getId());

        return checkoutItem;
    }

    public static CheckoutItemDTO toDTO() {
        CheckoutItemDTO checkoutItemDTO = new CheckoutItemDTO();

        return checkoutItemDTO;
    }
    
}
