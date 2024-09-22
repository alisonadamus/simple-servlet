package com.alisonadamus.simpleservlet.service;

import com.alisonadamus.simpleservlet.persistence.Cart;
import com.alisonadamus.simpleservlet.persistence.Product;
import java.math.BigDecimal;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    private final ProductService productService;

    public CartServiceImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public Cart getNewCart() {
        return new Cart();
    }

    @Override
    public void addProduct(Cart cart, Product product, Integer quantity) {
        cart.addProduct(product, quantity);
    }

    @Override
    public void addProduct(Cart cart, Long prodId, Integer quantity) {
        cart.addProduct(productService.getProductById(prodId), quantity);
    }

    @Override
    public void delProduct(Cart cart, Product product, Integer quantity) {
        cart.delProduct(product, quantity);
    }

    @Override
    public BigDecimal getSum(Cart cart) {
        return cart.getSum();
    }

    @Override
    public void printCart(Cart cart) {
        cart.getCartMap().forEach((product, quantity) ->
            System.out.println("Product" + product + "; Quantity: " + quantity)
        );
    }

    @Override
    public int getProductQuantity(Cart cart, Product product) {
        return cart.getCartMap().getOrDefault(product, 0);
    }

    @Override
    public int getProductQuantity(Cart cart, Long prodId) {
        return cart.getCartMap().getOrDefault(productService.getProductById(prodId), 0);
    }
}
