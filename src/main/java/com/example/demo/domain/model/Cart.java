package com.example.demo.domain.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Cart implements Serializable {

    private int itemId;
    private String itemName;
    private double price;
    private char itemSize; // size
    private int quantity;  // 購入数
}
