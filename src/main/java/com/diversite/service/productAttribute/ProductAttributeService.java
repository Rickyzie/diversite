package com.diversite.service.productAttribute;

import com.diversite.entity.productAttribute.ProductAttributeEntity;
import com.diversite.entity.productAttribute.ProductAttributeIdEntity;
import com.diversite.mapper.productAttribute.ProductAttributeMapper;import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductAttributeService {
    private final ProductAttributeMapper productAttributeMapper;


    @Autowired
    public ProductAttributeService(ProductAttributeMapper productAttributeMapper) {
        this.productAttributeMapper = productAttributeMapper;
    }

    @Transactional
    public  List<ProductAttributeEntity> getAllProductAttributes(Integer productId) {
       return productAttributeMapper.getAllProductAttributes(productId);
    }

    @Transactional
    public Boolean addProductAttribute(ProductAttributeIdEntity productAttributeIdEntity) {
        return productAttributeMapper.addProductAttribute(productAttributeIdEntity);
    }
}