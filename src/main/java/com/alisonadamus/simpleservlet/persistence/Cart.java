package com.alisonadamus.simpleservlet.persistence;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Cart {

    Map<Product, Integer> cartMap = new HashMap<>();

    public Map<Product, Integer> getCartMap() {
        return cartMap;
    }

    public void addProduct(Product product, Integer quantity) {
        cartMap.put(product, cartMap.getOrDefault(product, 0) + quantity);
    }


    public void delProduct(Product product, Integer quantity) {
        if (cartMap.containsKey(product)) {
            int currentQuantity = cartMap.get(product);
            int newQuantity = currentQuantity - quantity;

            if (newQuantity > 0) {
                cartMap.put(product, newQuantity);
            } else {
                cartMap.remove(product);
            }
        }
    }

    public BigDecimal getSum() {
        return cartMap.entrySet().stream()
            .map(entry -> entry.getKey().getCost().multiply(BigDecimal.valueOf(entry.getValue())))
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
