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
     * カートに追加されているアイテムの合計金額を算出
     */
    public double calcTotalPrice(List<Cart> cartItems) {
        double totalPrice = 0;
        for (Cart cartItem : cartItems) {
            double price = cartItem.getPrice();
            int quantity = cartItem.getQuantity();
            totalPrice += (price * quantity);
        }
        totalPrice = (Math.floor(totalPrice * 100) / 100);
        return totalPrice;
    }

    /**
     * カートにあるアイテム情報を削除
     * @return List<Cart>
     */
    public void deleteItemsFromCart(int itemId) {
        try {
            cartMybatisDao.deleteItemsFromCart(itemId);
        } catch (DataAccessException e) {
            throw e;
        }
    }

    /**
     * アイテムの購入数を変更
     */
    public void updateItemQuantity(int itemId, int quantity) {
        try {
            cartMybatisDao.updateItemQuantity(itemId, quantity);
        } catch (DataAccessException e) {
            throw e;
        }
    }
}
