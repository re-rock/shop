package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    /**
     * ホーム画面のGet用メソッド
     */
    @GetMapping("/home")
    public String getHome(Model model) {
        model.addAttribute("contents", "home :: home_contents");
        return "base";
    }
}
