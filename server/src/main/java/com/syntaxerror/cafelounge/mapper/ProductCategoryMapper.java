package com.syntaxerror.cafelounge.mapper;

import com.syntaxerror.cafelounge.dto.ProductCategoryDTO;
import com.syntaxerror.cafelounge.model.ProductCategory;

public class ProductCategoryMapper {

    public static ProductCategory toEntity(ProductCategoryDTO productCategoryDTO) {
        ProductCategory productCategory = new ProductCategory();

        productCategory.setId(productCategoryDTO.getId());
        productCategory.setName(productCategoryDTO.getName());
        productCategory.setDescription(productCategoryDTO.getDescription());

        return productCategory;
    }

    public static ProductCategoryDTO toDTO(ProductCategory productCategory) {
        ProductCategoryDTO productCategoryDTO = new ProductCategoryDTO();

        productCategoryDTO.setId(productCategory.getId());
        productCategoryDTO.setName(productCategory.getName());
        productCategoryDTO.setDescription(productCategory.getDescription());

        return productCategoryDTO;
    }
}
