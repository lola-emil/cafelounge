package com.syntaxerror.cafelounge.mapper;

import com.syntaxerror.cafelounge.dto.ProductStockHistoryDTO;
import com.syntaxerror.cafelounge.model.ProductStockHistory;

public class ProductStockHistoryMapper {

    ProductStockHistoryDTO toDTO(ProductStockHistory productStockHistory) {
        ProductStockHistoryDTO productStockHistoryDTO = new ProductStockHistoryDTO();

        productStockHistoryDTO.setId(productStockHistory.getId());
        productStockHistoryDTO.setProduct(ProductMapper.toDTO(productStockHistory.getProduct()));
        productStockHistoryDTO.setReason(productStockHistory.getReason());
        productStockHistoryDTO.setModifiedBy(productStockHistory.getModifiedBy());
        productStockHistoryDTO.setQuantityChanged(productStockHistory.getQuantityChanged());

        return productStockHistoryDTO;
    }

    ProductStockHistory toEntity(ProductStockHistoryDTO productStockHistoryDTO) {
        ProductStockHistory productStockHistory = new ProductStockHistory();

        productStockHistory.setId(productStockHistoryDTO.getId());
        productStockHistory.setProduct(ProductMapper.toEntity(productStockHistoryDTO.getProduct()));
        productStockHistory.setReason(productStockHistoryDTO.getReason());
        productStockHistory.setModifiedBy(productStockHistoryDTO.getModifiedBy());
        productStockHistory.setQuantityChanged(productStockHistoryDTO.getQuantityChanged());

        return productStockHistory;
    }
}
