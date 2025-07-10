package com.lolaemil.cafelounge.controller;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AuthController {

    @GetMapping("/login")
    String loginPage(@RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "username", required = false) String username,
            HttpServletRequest request,
            Model model) {

        CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
        model.addAttribute("_csrf", token);
        
        if (error != null)
            model.addAttribute("error", "Invalid username or password");

        return "login";
    }

}
