package com.example.demo.domain.service;

import com.example.demo.domain.model.Item;
import com.example.demo.domain.repository.ItemMybatisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("CategoryService")
public class CategoryService {

    @Autowired
    ItemMybatisDao itemMybatisDao;

    // 対象カテゴリのアイテム数を取得する
    public int countCategoryItems(String categoryType) {
        int count = itemMybatisDao.countCategoryItems(categoryType);
        return count;
    }
    // カテゴリタイプから該当商品をDBから取得する
    public List<Item> selectCategoryItems(String categoryType) {
        List<Item> items = itemMybatisDao.selectItems(categoryType);
        return items;
    }
}
