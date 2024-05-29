package com.Software_Engineering.Software_Eng.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IssueBoardController {
    @GetMapping("/")
    public String index() {
        System.out.println("IssueBoardController.index");
        return "index";
    }
}