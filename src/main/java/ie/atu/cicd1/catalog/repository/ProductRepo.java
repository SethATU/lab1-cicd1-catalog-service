package ie.atu.cicd1.catalog.repository;

import ie.atu.cicd1.catalog.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo
        extends JpaRepository<Product, Long> {
}
