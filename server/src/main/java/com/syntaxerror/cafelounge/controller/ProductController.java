package com.syntaxerror.cafelounge.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
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

    ProductDTO mapToDTO(Product product) {
        ProductDTO dto = new ProductDTO();

        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());

        return dto;
    }

    @GetMapping
    public ResponseEntity<Page<ProductDTO>> getProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {
        Sort sort = direction.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        PageRequest pageable = PageRequest.of(page, size, sort);

        Page<ProductDTO> productPage = productRepo.findAll(pageable).map(this::mapToDTO);

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
    public ResponseEntity<Product> addProduct(
        @Valid @RequestBody ProductDTO productBody,
        Authentication authenticattion) {
        User user = userRepo.findByUsername(authenticattion.getName()).get();

        Product product = new Product();

        product.setProductCode(productBody.getProductCode());
        product.setName(productBody.getName());
        product.setDescription(productBody.getDescription());
        product.setPrice(productBody.getPrice());
        product.setUser(user);

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


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        productRepo.deleteById(id);

        return ResponseEntity.ok("Deleted");
    }
}
