package ie.atu.cicd1.catalog.service;

import ie.atu.cicd1.catalog.dto.CreateProductRequest;
import ie.atu.cicd1.catalog.model.Category;
import ie.atu.cicd1.catalog.model.Product;
import ie.atu.cicd1.catalog.repository.CatagoryRepo;
import ie.atu.cicd1.catalog.repository.ProductRepo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepo pRepo;
    private final CatagoryRepo cRepo;

    public ProductService(ProductRepo pRepo, CatagoryRepo cRepo) {
        this.pRepo = pRepo;
        this.cRepo = cRepo;
    }

    public List<Product> getAll() {
        return pRepo.findAll();
    }

    public Product create(CreateProductRequest request) {
        if (request.categoryId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Category id is required");
        }
        Category category = cRepo.findById(request.categoryId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Category does not exsist"));
        Product product = new Product();
        product.setName(request.name());
        product.setPrice(request.price());
        product.setCategory(category);

        return pRepo.save(product);
    }

    public Product getById(Long id) {
        return pRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
    }

    public List<Product> getByMinimumPrice(BigDecimal minPrice) {
        return pRepo.findByMinimumPrice(minPrice);
    }

    public void delete(Long id) {
        pRepo.deleteById(id);
    }

    public List<Product> getByCategoryName(String categoryName) {
        return cRepo.findByCategoryName(categoryName);
    }
}
