package com.example.demo.controller;

import com.example.demo.domain.service.CartService;
import com.example.demo.domain.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CheckoutController {

    @Autowired
    CheckoutService checkoutService;

    /**
     * チェックアウト画面のGet用メソッド
     */
    @GetMapping("/checkout")
    public String returnHome(Model model) {
        // カートテーブルのアイテムをすべて削除
        checkoutService.deleteAllItem();

        model.addAttribute("contents", "checkout");
        return "base";
    }
}

