package com.lolaemil.cafelounge.controller;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/activity")
public class ActivityController {


    @ModelAttribute
    void addCsrfToken(Model model, HttpServletRequest request) {
        CsrfToken csrfToken = (CsrfToken) request.getAttribute("_csrf");
        
        if (csrfToken != null)
            model.addAttribute("_csrf", csrfToken);
    }

    @GetMapping
    String activity() {
        return "redirect:/activity/billing-queue";
    }
    
    @GetMapping("/billing-queue")
    String billingQueuePage() {
        return "activity/billing-queue";
    }

    @GetMapping("/order-history")
    String orderHistoryPage() {
        return "activity/order-history";
    }

    @GetMapping("/tables")
    String tablesPage() {
        return "activity/tables";
    }

}
