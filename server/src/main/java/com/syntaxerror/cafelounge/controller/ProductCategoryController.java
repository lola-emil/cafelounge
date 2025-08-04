package com.syntaxerror.cafelounge.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.syntaxerror.cafelounge.dto.ProductCategoryDTO;
import com.syntaxerror.cafelounge.dto.UpdateProductCategoryDTO;
import com.syntaxerror.cafelounge.mapper.ProductCategoryMapper;
import com.syntaxerror.cafelounge.model.ProductCategory;
import com.syntaxerror.cafelounge.repo.ProductCategoryRepo;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/product-categories")
public class ProductCategoryController {

    @Autowired
    ProductCategoryRepo productCategoryRepo;

    @GetMapping
    public ResponseEntity<List<ProductCategoryDTO>> getCategories() {
        List<ProductCategoryDTO> categories = productCategoryRepo.findAll().stream()
                .map(ProductCategoryMapper::toDTO).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductCategoryDTO> getCategoryById(
            @PathVariable Long id) {
        Optional<ProductCategory> category = productCategoryRepo.findById(id);

        if (!category.isPresent())
            return ResponseEntity.notFound().build();

        return ResponseEntity.status(HttpStatus.OK).body(ProductCategoryMapper.toDTO(category.get()));
    }

    @PostMapping
    public ResponseEntity<ProductCategoryDTO> addCategory(
            @RequestBody @Valid ProductCategoryDTO productCategoryDTO) {
        ProductCategory product = ProductCategoryMapper.toEntity(productCategoryDTO);
        ProductCategory newProductCategory = productCategoryRepo.save(product);

        return ResponseEntity.status(HttpStatus.CREATED).body(ProductCategoryMapper.toDTO(newProductCategory));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProductCategoryDTO> updateCategory(
            @PathVariable Long id,
            @RequestBody @Valid UpdateProductCategoryDTO productCategoryDTO) {
        Optional<ProductCategory> matchedCategory = productCategoryRepo.findById(id);

        if (!matchedCategory.isPresent())
            return ResponseEntity.notFound().build();

        ProductCategory category = matchedCategory.get();

        category.setName(productCategoryDTO.getName());
        category.setDescription(productCategoryDTO.getDescription());

        ProductCategory newCategory = productCategoryRepo.save(category);

        return ResponseEntity.status(HttpStatus.OK).body(ProductCategoryMapper.toDTO(newCategory));
    }
}
