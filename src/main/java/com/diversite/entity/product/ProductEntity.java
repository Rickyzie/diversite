package com.diversite.entity.product;

import com.diversite.entity.productAttribute.ProductAttributeEntity;
import lombok.Data;

import java.util.List;

@Data
public class ProductEntity {
    private Integer id;
    private String name;
    private Long createTime;
    private Boolean isAvailable;
    private List<ProductAttributeEntity> productAttributeEntityList;
}
