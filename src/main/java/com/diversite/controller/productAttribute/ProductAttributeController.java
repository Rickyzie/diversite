package com.diversite.controller.productAttribute;

import com.diversite.entity.product.ProductEntity;
import com.diversite.entity.productAttribute.ProductAttributeEntity;
import com.diversite.entity.productAttribute.ProductAttributeIdEntity;
import com.diversite.entity.user.UserEntity;
import com.diversite.response.ApiResponse;
import com.diversite.service.product.ProductService;
import com.diversite.service.productAttribute.ProductAttributeService;
import org.postgresql.util.PSQLException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productAttribute")
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
    @PostMapping
    public ResponseEntity<ApiResponse<Boolean>> addProductAttribute(ProductAttributeIdEntity productAttributeIdEntity)  {
        try {
            Boolean isAdded = productAttributeService.addProductAttribute(productAttributeIdEntity);
            if(isAdded){
                return ResponseEntity.ok(new ApiResponse<Boolean>(true));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new ApiResponse<>("addProductAttribute error" ));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse<>(" error" ));
    }
}
