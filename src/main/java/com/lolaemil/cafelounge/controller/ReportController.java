package com.lolaemil.cafelounge.controller;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/report")
public class ReportController {

    @ModelAttribute
    void addCsrfToken(Model model, HttpServletRequest request) {
        CsrfToken token = (CsrfToken) request.getAttribute("_csrf");

        if (token != null)
            model.addAttribute("_csrf", token);
    }

    @GetMapping
    String reportPage(Model model, HttpServletRequest request) {
        return "report";
    }
}
