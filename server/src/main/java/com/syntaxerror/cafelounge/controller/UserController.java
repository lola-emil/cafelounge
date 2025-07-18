package com.syntaxerror.cafelounge.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.syntaxerror.cafelounge.dto.UserDTO;
import com.syntaxerror.cafelounge.model.User;
import com.syntaxerror.cafelounge.repo.UserRepo;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    UserRepo userRepo;
    
    @PostMapping
    ResponseEntity<User> addUser(@RequestBody @Valid UserDTO userBody) {
        User user = new User();

        user.setName(userBody.getName());
        user.setUsername(userBody.getUsername());

        User newUser = userRepo.save(user);

        return ResponseEntity.status(200).body(newUser);
    }

    @GetMapping("/{id}")
    ResponseEntity<User> getUser(@PathVariable Long id) {
        Optional<User> user = this.userRepo.findById(id);
        
        if (!user.isPresent())
            return ResponseEntity.notFound().build();

        return ResponseEntity.status(200).body(user.get());
    }
}
