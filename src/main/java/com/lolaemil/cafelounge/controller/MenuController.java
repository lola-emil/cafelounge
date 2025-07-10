package com.lolaemil.cafelounge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lolaemil.cafelounge.model.Menu;
import com.lolaemil.cafelounge.model.MenuCategory;
import com.lolaemil.cafelounge.repository.MenuCategoryRepository;
import com.lolaemil.cafelounge.repository.MenuRepository;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class MenuController {

    @Autowired
    MenuCategoryRepository menuCategoryRepo;

    @Autowired
    MenuRepository menuRepo;

    @ModelAttribute
    void addCsrfToken(Model model, HttpServletRequest request) {
        CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
        if (token != null)
            model.addAttribute("_csrf", token);
    }

    @GetMapping("/menu")
    String menuRedirect() {
        return "redirect:/";
    }

    @GetMapping
    String menuPage(Model model) {
        List<MenuCategory> menuCategories = menuCategoryRepo.findAll();
        List<Menu> menus = menuRepo.findAll();

        model.addAttribute("menus", menus);
        model.addAttribute("menuCategories", menuCategories);

        return "menu";
    }
}
