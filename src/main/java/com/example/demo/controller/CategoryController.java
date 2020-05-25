package com.example.demo.controller;

import com.example.demo.domain.model.Item;
import com.example.demo.domain.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import static com.example.demo.Constants.CATEGORY_NAME_MAP;

@Controller
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    /**
     * ガテゴリー画面のGET用メソッド
     */
    @GetMapping("/category/{type}")
    public String getCategory(@PathVariable("type") String type, Model model) {
        // 選択されたカテゴリー
        String categoryType = type;
        try {
            // カテゴリー毎の登録商品をDBから取得する
            int totalCategoryItems = categoryService.countCategoryItems(categoryType);
            model.addAttribute("totalCategoryItems", totalCategoryItems);
            // カテゴリー毎の全商品情報をDBから取得する
            List<Item> itemList = categoryService.selectCategoryItems(categoryType);
            model.addAttribute("itemList", itemList);
        } catch (DataAccessException e) {
            model.addAttribute("title", "failed to DB access...");
        }
        model.addAttribute("title", CATEGORY_NAME_MAP.get(type));
        // 対象カテゴリの画像ファイル名
        model.addAttribute("imgFileName", type);
        model.addAttribute("contents", "category :: category_contents");
        return "base";
    }
}
