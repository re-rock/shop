package com.example.demo.controller;

import com.example.demo.domain.model.Cart;
import com.example.demo.domain.service.CartService;
import com.example.demo.domain.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static org.springframework.util.ObjectUtils.isEmpty;

@Controller
public class CartController {

    @Autowired
    CartService cartService;
    @Autowired
    ItemService itemService;

    /**
     * カート状況を表示
     */
    @GetMapping(value = "/cart/show")
    public String showCartInfo(Model model) {
        // カートにアイテムが有る状態
        boolean isEmpty = true;
        // カートテーブルに追加されている全アイテムを取得する
        List<Cart> cartItems = cartService.selectItemsFromCart();
        if (!isEmpty(cartItems)) {
            //if (cartItems == null) {
            isEmpty = false;
        }
        model.addAttribute("cartItems", cartItems);
        model.addAttribute("itemsNumber", cartItems.size());
        model.addAttribute("isEmpty", isEmpty);
        model.addAttribute("contents", "cart");
        return "base";
    }

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
        List<Cart> cartItems = cartService.selectItemsFromCart();
        if (!isEmpty(cartItems)) {
        //if (cartItems == null) {
            isEmpty = false;
        }
        model.addAttribute("cartItems", cartItems);
        model.addAttribute("itemsNumber", cartItems.size());
        model.addAttribute("isEmpty", isEmpty);
        model.addAttribute("contents", "cart");
        return "base";
    }

    /**
     * カートから対象アイテム削除
     */
    @GetMapping("/cart")
    public String deleteItem(@RequestParam String item_id, Model model) {
        boolean isEmpty = true;
        // 対象のアイテムをカートテーブルから削除
        cartService.deleteItemsFromCart(item_id);
        // カートテーブルに追加されている全アイテムを取得する
        List<Cart> cartItems = cartService.selectItemsFromCart();
        if (!isEmpty(cartItems)) {
            //if (cartItems == null) {
            isEmpty = false;
        }
        model.addAttribute("cartItems", cartItems);
        model.addAttribute("itemsNumber", cartItems.size());
        model.addAttribute("isEmpty", isEmpty);
        model.addAttribute("contents", "cart");
        return "base";
    }
}
