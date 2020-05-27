package com.example.demo.domain.model;

import lombok.Data;

@Data
public class Item {
    private int   itemId;       // 商品ID
    private String itemName;     // 商品名
    private String itemCategory; // カテゴリー
    private float  price;        // 価格
    private int    stockS;       // Sサイズ在庫
    private int    stockM;       // Mサイズ在庫
    private int    stockL;       // Lサイズ在庫
    private String description;  // 商品概要
    private String features;     // 商品特徴
}

