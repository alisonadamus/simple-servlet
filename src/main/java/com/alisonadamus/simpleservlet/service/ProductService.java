package com.alisonadamus.simpleservlet.service;

import com.alisonadamus.simpleservlet.persistence.Product;
import java.util.List;

public interface ProductService {
    List<Product> getProductList();
    void saveOrUpdate(Product product);
    Product getProductById(Long id);
    void deleteById(Long id);

}
