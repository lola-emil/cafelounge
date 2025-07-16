package com.syntaxerror.cafelounge.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
    @GetMapping    
    String helloWorld() {
        return "Hello, World!";
    }
}
