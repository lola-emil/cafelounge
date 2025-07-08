package com.lolaemil.cafelounge.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menu")
public class MenuController {
    @GetMapping
    String menuPage(Model model) {
        List<String> menuCategories = new ArrayList<String>();

        menuCategories.add("Breads");
        menuCategories.add("Cakes");
        menuCategories.add("Donuts");
        menuCategories.add("Sandwich");


        model.addAttribute("menuCategories", menuCategories);
        
        return "menu";
    }
}
