package com.example.demo.controller;

import com.example.demo.domain.model.Cart;
import com.example.demo.domain.service.CartService;
import com.example.demo.domain.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CartController {

    @Autowired
    CartService cartService;
    @Autowired
    ItemService itemService;

    /**
     * カートに追加処理
     */
    @PostMapping(value = "/cart", params = "add")
    public String cartAddItem(@ModelAttribute("cart") Cart cart, Model model) {
        // カートにアイテムが有る状態
        boolean isEmpty = true;
        // カートテーブルに追加されたアイテムを追加
        cartService.insertItemToCart(cart);
        // カートテーブルに追加されている全アイテムを取得する
        List<Cart> cartItems = cartService.selectItemsFromCart(cart.getItemId());
        if (cartItems == null) {
            isEmpty = false;
        }
        model.addAttribute("cartItems", cartItems);
        model.addAttribute("isEmpty", isEmpty);
        return "cart";
    }
}
