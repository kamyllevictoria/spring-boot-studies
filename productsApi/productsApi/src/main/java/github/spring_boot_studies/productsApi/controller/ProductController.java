package github.spring_boot_studies.productsApi.controller;

import github.spring_boot_studies.productsApi.exceptions.ProductException;
import github.spring_boot_studies.productsApi.model.Product;
import github.spring_boot_studies.productsApi.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/save")
    public Product save(@RequestBody Product product){
        return productService.save(product);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Product> getById(@PathVariable Integer id){
        Product product = productService.getById(id)
                .orElseThrow(() -> new ProductException("ID deleted or non-existent"));

        return ResponseEntity.ok(product);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Product>> getAllProductsList(){
        List<Product> products = productService.get();
        return ResponseEntity.ok(products);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Integer id){
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Void> updateProduct(@PathVariable("id") Integer id,
                                              @RequestBody Product product){
        productService.update(id, product);
        return ResponseEntity.ok().build();
    }
}
