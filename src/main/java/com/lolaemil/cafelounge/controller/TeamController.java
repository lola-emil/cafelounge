package com.lolaemil.cafelounge.controller;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/teams")
public class TeamController {
    
    @ModelAttribute
    void addCsrfToken(HttpServletRequest request, Model model) {
        CsrfToken token = (CsrfToken) request.getAttribute("_csrf");

        if (token != null)
            model.addAttribute("_csrf", token);
    }

    @GetMapping
    String teamsPage() {
        return "teams";
    }
}
