package com.example.demo;

import java.util.*;

public class Constants {
    // カテゴリー名リスト
    public static final List<String> CATEGORIE_VALUE_LIST = new ArrayList<>(
            Arrays.asList(
                    "mens_outerwear",
                    "mens_tshirts",
                    "ladies_outerwear",
                    "ladies_tshirts"
            ));
    // カテゴリー毎のimg情報
    public static final Map<String, String> CATEGORY_NAME_MAP = new HashMap<String, String>() {
        {
            put("mens_outerwear", "Men's Outerwear");
            put("mens_tshirts", "Men's T-Shirts");
            put("ladies_outerwear", "Ladies Outerwear");
            put("ladies_tshirts", "Ladies T-Shirts");
        }
    };
}
