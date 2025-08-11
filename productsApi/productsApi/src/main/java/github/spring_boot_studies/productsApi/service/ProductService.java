package github.spring_boot_studies.productsApi.service;

import github.spring_boot_studies.productsApi.exceptions.ProductException;
import github.spring_boot_studies.productsApi.model.Product;
import github.spring_boot_studies.productsApi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;
@Service
public class ProductService {
    private final ProductRepository productRepository;
    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);


    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<Product>getById(Integer id){
        if (id <= 0) {
            throw new IllegalArgumentException("ID cant be lower or equal than zero");
        }
        return productRepository.findById(id);
    }

    public List<Product>get(){
        return productRepository.findAll();
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public void delete(Integer id){
        if(!productRepository.existsById(id)){
            throw new ProductException("Product with id: " + id + "not found.");
        }
        productRepository.deleteById(id);
    }

    public void update(Integer id, Product product){
        if (id <= 0) {
            throw new IllegalArgumentException("ID cant be lower or equal than zero");
        }

        logger.info("trying to update product with id: {}", id);
        Optional<Product> existingProductOptional = productRepository.findById(id);

        if(existingProductOptional.isPresent()){
           Product existingProduct = existingProductOptional.get();

           existingProduct.setName(product.getName());
           existingProduct.setCategory(product.getCategory());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setInventory(product.getInventory());
            existingProduct.setPrice(product.getPrice());

            productRepository.save(existingProduct);
        } else{
            logger.warn("ID {} not found.", id);
            throw new ProductException("Product with ID " + id + " not found.");
        }

    }
}
