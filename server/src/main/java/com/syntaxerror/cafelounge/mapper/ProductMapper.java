package com.syntaxerror.cafelounge.mapper;

import com.syntaxerror.cafelounge.dto.ProductDTO;
import com.syntaxerror.cafelounge.model.Product;

public class ProductMapper {

    public static Product toEntity(ProductDTO productDTO) {
        Product product = new Product();

        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setSku(productDTO.getSku());
        product.setUnitPrice(productDTO.getUnitPrice());
        product.setActive(productDTO.isActive());
        product.setCategory(ProductCategoryMapper.toEntity(productDTO.getProductCategory()));

        return product;
    }

    public static ProductDTO toDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();

        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setSku(product.getSku());
        productDTO.setUnitPrice(product.getUnitPrice());
        productDTO.setActive(product.isActive());
        productDTO.setProductCategory(ProductCategoryMapper.toDTO(product.getCategory()));

        return productDTO;
    }
}
