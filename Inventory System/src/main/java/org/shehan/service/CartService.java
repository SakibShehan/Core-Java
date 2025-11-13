package org.shehan.service;

import org.shehan.dao.CartDaoImpl;
import org.shehan.dao.ProductDAOimpl;
import org.shehan.dao.ProductDao;
import org.shehan.model.Cart;
import org.shehan.dao.CartDao;

import java.util.*;

public class CartService {

    private static final CartDao cartDao = new CartDaoImpl();
     static List<Cart> cart = new ArrayList<>();
    public static void addCart(int productId, int quantity) {
        cart.add(new Cart(productId, quantity));
    }
    public static List<Cart> getCartItems() {
        return cart;
    }

    public void clearCart() {
        cart.clear();
    }

    public boolean isEmpty() {
        return cart.isEmpty();
    }
    public static boolean CheckProduct(int productId, int quantity) throws Exception {

        return cartDao.CheckProduct(productId,quantity);
    }
}
