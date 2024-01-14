package com.diversite.error;

import com.diversite.entity.product.ProductEntity;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

@Data
@RequiredArgsConstructor
public class ApiError  {
    @NonNull
    private String name ;
    @NonNull
    private String message;
}


