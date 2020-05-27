package com.example.demo.domain.repository;

import com.example.demo.domain.model.Item;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemMybatisDao {

    // カテゴリー毎の登録商品数を取得
    int countCategoryItems(String categoryType);
    // select item information from DB
    Item selectItemInfo(int ItemId);
    // 選択されたカテゴリーの全商品情報を取得
    List<Item> selectItems(String categoryType);
}
