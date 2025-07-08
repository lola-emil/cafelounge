package com.lolaemil.cafelounge.controller;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
@RequestMapping("/report")
public class ReportController {
    @GetMapping
    String reportPage() {
        return "report";
    }
}
