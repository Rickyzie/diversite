package com.diversite.entity.admin;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;


@Data
@RequiredArgsConstructor
public class AdminEntity {
    private Integer id; // Excluded from the required args constructor

    @NonNull
    private final String adminName;

    @NonNull
    private final String passwordHash;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
