package com.diversite.mapper.productAttribute;

import com.diversite.entity.productAttribute.ProductAttributeEntity;
import com.diversite.entity.productAttribute.ProductAttributeIdEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductAttributeMapper {
    List<ProductAttributeEntity> getAllProductAttributes(Integer id);

    Boolean addProductAttribute(ProductAttributeIdEntity productAttributeIdEntity);
}
