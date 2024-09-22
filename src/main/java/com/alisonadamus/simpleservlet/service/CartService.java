package com.alisonadamus.simpleservlet.service;

import com.alisonadamus.simpleservlet.persistence.Cart;
import com.alisonadamus.simpleservlet.persistence.Product;
import java.math.BigDecimal;

public interface CartService {

    Cart getNewCart();
    void addProduct(Cart cart, Product product, Integer quantity);
    void addProduct(Cart cart, Long prodId, Integer quantity);
    void delProduct(Cart cart, Product product, Integer quantity);
    BigDecimal getSum(Cart cart);
    void printCart(Cart cart);
    int getProductQuantity(Cart cart, Product product);
    int getProductQuantity(Cart cart, Long prodId);

}
