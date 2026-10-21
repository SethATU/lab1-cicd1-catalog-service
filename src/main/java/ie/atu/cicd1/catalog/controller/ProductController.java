package ie.atu.cicd1.catalog.controller;

import ie.atu.cicd1.catalog.dto.CreateProductRequest;
import ie.atu.cicd1.catalog.model.Product;
import ie.atu.cicd1.catalog.service.ProductService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController
{
    private final ProductService productService;

    public ProductController(ProductService productService)
    {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAll()
    {
        return productService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody CreateProductRequest request) {
        return productService.create(request);
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return productService.getById(id);
    }

    @GetMapping("/min-price")
    public List<Product> getByMinimumPrice(@RequestParam("price") BigDecimal price) {
        return productService.getByMinimumPrice(price);
    }

    @DeleteMapping("deleteId/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        productService.getById(id);
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/by-category")
    public List<Product> getByCategoryName(@RequestParam("categoryName") String categoryName) {
        return productService.getByCategoryName(categoryName);
    }
}
