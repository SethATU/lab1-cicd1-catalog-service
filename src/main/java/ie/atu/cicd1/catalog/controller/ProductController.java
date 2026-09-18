package ie.atu.cicd1.catalog.controller;

import ie.atu.cicd1.catalog.model.Product;
import ie.atu.cicd1.catalog.service.ProductService;
import org.springframework.web.bind.annotation.*;

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
    public Product create(Product product)
    {
        return productService.create(product);
    }
}
