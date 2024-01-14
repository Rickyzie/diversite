package com.diversite.controller.productAttribute;

import com.diversite.entity.product.ProductEntity;
import com.diversite.entity.productAttribute.ProductAttributeEntity;
import com.diversite.entity.user.UserEntity;
import com.diversite.service.product.ProductService;
import com.diversite.service.productAttribute.ProductAttributeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productAttribute")
public class ProductAttributeController {

    private final ProductAttributeService productAttributeService;

    public ProductAttributeController(ProductAttributeService productAttributeService) {
        this.productAttributeService = productAttributeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<ProductAttributeEntity>> getAllProductAttributes(@PathVariable Integer id) {
        List<ProductAttributeEntity> productAttributeEntitys = productAttributeService.getAllProductAttributes(id);
        return ResponseEntity.ok(productAttributeEntitys);
    }

}
