package com.lolaemil.cafelounge.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/")
public class MenuController {

    @GetMapping("/menu")
    String menuRedirect() {
        return "redirect:/";
    }
    
    @GetMapping
    String menuPage(Model model, HttpServletRequest request) {
        List<String> menuCategories = new ArrayList<String>();

        menuCategories.add("Breads");
        menuCategories.add("Cakes");
        menuCategories.add("Donuts");
        menuCategories.add("Sandwich");

        model.addAttribute("menuCategories", menuCategories);

        CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
        model.addAttribute("_csrf", token);
        
        return "menu";
    }
}
