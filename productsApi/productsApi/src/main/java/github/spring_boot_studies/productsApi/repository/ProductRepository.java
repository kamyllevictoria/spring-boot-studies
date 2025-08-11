package github.spring_boot_studies.productsApi.repository;

import github.spring_boot_studies.productsApi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
