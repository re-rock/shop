package com.example.demo.controller;

import com.example.demo.domain.model.Item;
import com.example.demo.domain.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.regex.Pattern;

@Controller
public class ItemController {

        @Autowired
        ItemService itemService;

        /**
         * カテゴリー画面のGET用メソッド
         */
        @GetMapping("/detail/{itemId}")
        public String getCategory(@PathVariable("itemId")int itemId, Model model) {
            // get selected item information from db
            Item item = itemService.selectItemInfo(itemId);
            // flag of can purchase item
            if (item.getStockS() > 0 && item.getStockM() > 0 && item.getStockL() > 0) {
                model.addAttribute("isAvailable", true);
            }
            // split the features sentence with period
            String[] features = item.getFeatures().split(Pattern.quote("."));
            model.addAttribute("item", item);
            model.addAttribute("features", features);
            model.addAttribute("contents", "item :: item_contents");
            return "base";
    }
}
