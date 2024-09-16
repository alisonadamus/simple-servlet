package com.alisonadamus.simpleservlet;

import com.alisonadamus.simpleservlet.persistence.Product;
import com.alisonadamus.simpleservlet.persistence.ProductRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/products")
public class MainServlet extends HttpServlet {

    private String productList = "";

    @Override
    public void init() {
        ProductRepository productRepository = (ProductRepository) getServletContext().getAttribute(
            "productRepository");
        List<Product> products = productRepository.getProducts();
        products.forEach(product -> productList += product + "\n");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
        Integer counter = (Integer) request.getSession(true).getAttribute("counter");
        if (counter == null) {
            counter = 0;
        }
        counter++;
        request.getSession(true).setAttribute("counter", counter);

        request.setAttribute("contextPath", request.getContextPath());
        request.setAttribute("servletPath", request.getServletPath());
        request.setAttribute("pathInfo", request.getPathInfo());
        request.setAttribute("queryString", request.getQueryString());
        request.setAttribute("param1", request.getParameter("param1"));
        request.setAttribute("param2", request.getParameter("param2"));
        request.setAttribute("user-agent", request.getHeader("User-Agent"));
        request.setAttribute("sessionCounter", counter);
        request.setAttribute("products", productList);

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}