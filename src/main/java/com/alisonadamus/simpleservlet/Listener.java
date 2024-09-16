package com.alisonadamus.simpleservlet;

import com.alisonadamus.simpleservlet.persistence.Product;
import com.alisonadamus.simpleservlet.persistence.ProductRepository;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import java.util.Random;

@WebListener
public class Listener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ProductRepository productRepository = new ProductRepository();
        Random random = new Random();
        for (int i = 1; i <= 10; i++) {
            productRepository.addProduct(new Product(i, "Product " + i,
                random.nextDouble() * 1000));
        }
        sce.getServletContext().setAttribute("productRepository", productRepository);
    }

}
