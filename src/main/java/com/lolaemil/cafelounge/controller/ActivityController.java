package com.lolaemil.cafelounge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/activity")
public class ActivityController {

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
