package com.syntaxerror.cafelounge.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.syntaxerror.cafelounge.dto.ProductDTO;
import com.syntaxerror.cafelounge.model.Product;
import com.syntaxerror.cafelounge.model.User;
import com.syntaxerror.cafelounge.repo.ProductRepo;
import com.syntaxerror.cafelounge.repo.UserRepo;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    UserRepo userRepo;

    @GetMapping
    public ResponseEntity<Page<Product>> getProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {
        Sort sort = direction.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        PageRequest pageable = PageRequest.of(page, size, sort);

        Page<Product> productPage = productRepo.findAll(pageable);

        return ResponseEntity.ok(productPage);
    }

    @GetMapping("/{id}")
    ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> product = productRepo.findById(id);

        if (!product.isPresent())
            return ResponseEntity.notFound().build();
        
        return ResponseEntity.status(HttpStatus.OK).body(product.get());
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody @Valid ProductDTO productBody) {
        Product product = new Product();

        product.setProductCode(productBody.getProductCode());
        product.setName(productBody.getName());
        product.setDescription(productBody.getDescription());
        product.setPrice(productBody.getPrice());

        if (productBody.getUserId() != null) {
            Optional<User> user = userRepo.findById(productBody.getUserId());

            if (!user.isPresent())
                return ResponseEntity.notFound().build();

            product.setUser(user.get());
        }

        Product savedProduct = productRepo.save(product);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productBody) {
        Optional<Product> optionalProduct = productRepo.findById(id);

        if (!optionalProduct.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Product product = optionalProduct.get();

        if (productBody.getProductCode() != null) {
            product.setProductCode(productBody.getProductCode());
        }
        if (productBody.getName() != null) {
            product.setName(productBody.getName());
        }
        if (productBody.getDescription() != null) {
            product.setDescription(productBody.getDescription());
        }
        if (productBody.getPrice() != 0) {
            product.setPrice(productBody.getPrice());
        }

        Product updatedProduct = productRepo.save(product);

        return ResponseEntity.ok(updatedProduct);
    }

}
