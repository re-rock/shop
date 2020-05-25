package com.example.demo.domain.repository;

import com.example.demo.domain.model.Cart;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartMybatisDao {

    // Cartにアイテムを追加
    void insertItemToCart(Cart cart);
    // Cartにあるアイテムをすべて取得
    List<Cart> selectItemsFromCart(String itemId);
}
