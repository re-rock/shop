package com.example.demo.domain.service;

import com.example.demo.domain.model.Item;
import com.example.demo.domain.repository.ItemMybatisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("ItemService")
public class ItemService {

    @Autowired
    ItemMybatisDao itemMybatisDao;

    /**
     * select item info from db
     */
    public Item selectItemInfo(int itemId) {
        try {
            return itemMybatisDao.selectItemInfo(itemId);
        } catch (DataAccessException e) {
            throw e;
        }
    }
}
