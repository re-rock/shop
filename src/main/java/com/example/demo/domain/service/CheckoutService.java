package com.example.demo.domain.service;

import com.example.demo.domain.model.Cart;
import com.example.demo.domain.repository.CartMybatisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class CheckoutService {

    @Autowired
    CartMybatisDao cartMybatisDao;

    /**
     * カートテーブルにアイテムを登録する
     */
    public void deleteAllItem() {
        try {
            cartMybatisDao.deleteAllItem();
        } catch (DataAccessException e) {
            throw e;
        }
    }
}
