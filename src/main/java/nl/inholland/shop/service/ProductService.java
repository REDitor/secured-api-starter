package nl.inholland.shop.service;

import nl.inholland.shop.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();

    public ProductService() {
        products.add(new Product(1, "Clean code", "A book about writing better code", 11.99));
        products.add(new Product(2, "Head First Java", "Get started with Java Programming in a fun and easy to learn way", 45.00));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product addProduct(Product product) {
        products.add(product);
        return product;
    }
}
