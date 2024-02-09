package com.diversite.service.product;
import com.diversite.mapper.product.ProductMapper;
import com.diversite.entity.product.ProductEntity;
import com.diversite.mapper.productAttribute.ProductAttributeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductMapper productMapper;
    private final ProductAttributeMapper productAttributeMapper;
    @Autowired
    public ProductService(ProductMapper productMapper, ProductAttributeMapper productAttributeMapper) {
        this.productMapper = productMapper;
        this.productAttributeMapper = productAttributeMapper;
    }

    @Transactional
    public void addProduct(ProductEntity productEntity) {
        productMapper.insertProduct(productEntity);
    }

    @Transactional(readOnly = true)
    public ProductEntity getProductById(Integer id) {
        Optional<ProductEntity> productEntity = Optional.ofNullable(productMapper.getProductById(id));
        productEntity.ifPresent((value) -> value.setProductAttributeEntityList(productAttributeMapper.getAllProductAttributes(id)));
        return productEntity.orElse(null );
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