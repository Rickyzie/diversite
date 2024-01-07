package com.diversite.mapper.product;

import com.diversite.entity.product.ProductEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ProductMapper {
    void insertProduct(ProductEntity productEntity);
    ProductEntity getProductById(Integer id);
    List<ProductEntity> getAllProducts();
    void updateProduct(ProductEntity productEntity);
    void deleteProduct(Integer id);
}
