package com.alisonadamus.simpleservlet.persistence;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {

    private final Map<Long, Product> productMap = new HashMap<>();

    @PostConstruct
    public void init() {
        saveOrUpdate(new Product(1L, "Product 1", BigDecimal.valueOf(10.00)));
        saveOrUpdate(new Product(2L, "Product 2", BigDecimal.valueOf(20.00)));
        saveOrUpdate(new Product(3L, "Product 3", BigDecimal.valueOf(30.00)));
        saveOrUpdate(new Product(4L, "Product 4", BigDecimal.valueOf(40.00)));
        saveOrUpdate(new Product(5L, "Product 5", BigDecimal.valueOf(50.00)));
    }

    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    public void saveOrUpdate(Product product) {
        productMap.put(product.getId(), product);
    }

    public Product findById(Long id) {
        return productMap.get(id);
    }

    public void deleteById(Long id) {
        productMap.remove(id);
    }
}
