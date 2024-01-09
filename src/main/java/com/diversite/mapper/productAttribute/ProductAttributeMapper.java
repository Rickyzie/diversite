package com.diversite.mapper.productAttribute;

import com.diversite.entity.productAttribute.ProductAttributeEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductAttributeMapper {
    void getAllProductAttributes(Integer id);
}
