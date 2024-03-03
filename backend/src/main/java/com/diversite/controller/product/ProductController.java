package com.diversite.controller.product;

import com.diversite.entity.product.ProductEntity;
import com.diversite.error.ApiError;
import com.diversite.service.product.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Void> createProduct(@RequestBody ProductEntity productEntity) {
        productService.addProduct(productEntity);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Integer id) {
        Optional<ProductEntity> product = Optional.ofNullable(productService.getProductById(id));
        if(product.isPresent()){
            return ResponseEntity.ok(product.get());
        }else{
            return ResponseEntity.ok(new ApiError("EntityNotFound", "Product not found"));
        }
    }

    @GetMapping
    public ResponseEntity<List<ProductEntity>> getAllProductsWithAttributes() {
        List<ProductEntity> products = productService.getAllProductsWithAttributes();
        return ResponseEntity.ok(products);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateProduct(@PathVariable Integer id, @RequestBody ProductEntity productEntity) {
        productEntity.setId(id);
        productService.updateProduct(productEntity);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }
}
