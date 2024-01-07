package com.diversite.service.product;
import com.diversite.mapper.product.ProductMapper;
import com.diversite.entity.product.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    private final ProductMapper productMapper;

    @Autowired
    public ProductService(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Transactional
    public void addProduct(ProductEntity productEntity) {
        productMapper.insertProduct(productEntity);
    }

    @Transactional(readOnly = true)
    public ProductEntity getProductById(Integer id) {
        return productMapper.getProductById(id);
    }

    @Transactional(readOnly = true)
    public List<ProductEntity> getAllProducts() {
        return productMapper.getAllProducts();
    }

    @Transactional
    public void updateProduct(ProductEntity productEntity) {
        productMapper.updateProduct(productEntity);
    }

    @Transactional
    public void deleteProduct(Integer id) {
        productMapper.deleteProduct(id);
    }
}