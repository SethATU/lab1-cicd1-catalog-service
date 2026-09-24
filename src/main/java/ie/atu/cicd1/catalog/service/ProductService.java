package ie.atu.cicd1.catalog.service;

import ie.atu.cicd1.catalog.model.Product;
import ie.atu.cicd1.catalog.repository.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepo repo;

    public ProductService(ProductRepo repo) {
        this.repo = repo;
    }

    public List<Product> getAll() {
        return repo.findAll();
    }

    public Product create(Product product) {
        product.setId(null);
        return repo.save(product);
    }
}
