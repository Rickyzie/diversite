package com.diversite.entity.productAttribute;

import lombok.Data;

import java.util.List;

@Data
public class ProductAttributeEntity {
    private Integer productId;
    private Integer attributeId;
    private String attributeName;
    private String[] attributeValues;
}
