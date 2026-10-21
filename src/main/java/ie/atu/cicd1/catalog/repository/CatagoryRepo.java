package ie.atu.cicd1.catalog.repository;

import ie.atu.cicd1.catalog.model.Category;
import ie.atu.cicd1.catalog.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CatagoryRepo extends JpaRepository<Category,Long> {
@Query("""
     SELECT p
     FROM Product p
     JOIN p.category c
     WHERE LOWER(c.name) = LOWER(:categoryName)
     ORDER BY p.price ASC
     """)
List<Product> findByCategoryName(@Param("categoryName") String categoryName);
}
