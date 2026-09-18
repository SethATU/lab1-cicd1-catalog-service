package ie.atu.cicd1.catalog.service;

import ie.atu.cicd1.catalog.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private final List<Product> products = new ArrayList<>();
    private long nextId = 1;

        public List<Product> getAll() {
            return products;
        }

        public Product create(Product product) {
            product.setId(nextId++);
            products.add(product);
            return product;
        }
}
