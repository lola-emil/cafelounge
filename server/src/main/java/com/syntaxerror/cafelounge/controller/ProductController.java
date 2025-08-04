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

import com.syntaxerror.cafelounge.dto.ProductDTO;
import com.syntaxerror.cafelounge.dto.UpdateProductDTO;
import com.syntaxerror.cafelounge.mapper.ProductMapper;
import com.syntaxerror.cafelounge.model.Product;
import com.syntaxerror.cafelounge.repo.ProductRepo;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepo productRepo;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getProducts() {
        List<ProductDTO> products = productRepo.findAll().stream().map(ProductMapper::toDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(
            @PathVariable Long id) {

        Optional<Product> product = productRepo.findById(id);

        if (!product.isPresent())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(ProductMapper.toDTO(product.get()));
    }

    @PostMapping
    public ResponseEntity<ProductDTO> addProduct(
            @RequestBody @Valid ProductDTO productDTO) {
        Product product = ProductMapper.toEntity(productDTO);

        Product newProduct = productRepo.save(product);

        return ResponseEntity.status(HttpStatus.CREATED).body(ProductMapper.toDTO(newProduct));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(
            @PathVariable Long id,
            @RequestBody @Valid UpdateProductDTO productDTO) {
        Optional<Product> matchedProduct = productRepo.findById(id);

        if (!matchedProduct.isPresent())
            return ResponseEntity.notFound().build();

        Product product = matchedProduct.get();
        Product updatedProduct = productRepo.save(product);

        return ResponseEntity.status(HttpStatus.OK).body(ProductMapper.toDTO(updatedProduct));
    }
}