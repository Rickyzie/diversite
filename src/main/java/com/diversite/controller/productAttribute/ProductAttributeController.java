package com.diversite.controller.productAttribute;

import com.diversite.entity.product.ProductEntity;
import com.diversite.service.product.ProductService;
import com.diversite.service.productAttribute.ProductAttributeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductAttributeController {

    private final ProductAttributeService productAttributeService;

    public ProductAttributeController(ProductAttributeService productAttributeService) {
        this.productAttributeService = productAttributeService;
    }


    @GetMapping("/{id}")
    public void getProductById(@PathVariable Integer id) {
        productAttributeService.getAllProductAttributes(id);
    }

}
