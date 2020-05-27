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
public class CartService {

    @Autowired
    CartMybatisDao cartMybatisDao;

    /**
     * カートテーブルにアイテムを登録する
     */
    public void insertItemToCart(Cart cart) {
        try {
            cartMybatisDao.insertItemToCart(cart);
        } catch (DataAccessException e) {
            throw e;
        }
    }

    /**
     * カートにあるアイテム情報を取得
     * @return List<Cart>
     */
    public List<Cart> selectItemsFromCart() {
        try {
            return cartMybatisDao.selectItemsFromCart();
        } catch (DataAccessException e) {
            throw e;
        }
    }

    /**
     * カートにあるアイテム情報を削除
     * @return List<Cart>
     */
    public void deleteItemsFromCart(String itemId) {
        try {
            cartMybatisDao.deleteItemsFromCart(itemId);
        } catch (DataAccessException e) {
            throw e;
        }
    }
}
