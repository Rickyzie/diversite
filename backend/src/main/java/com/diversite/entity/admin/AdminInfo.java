package com.diversite.entity.admin;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.OffsetTime;

@Data
@RequiredArgsConstructor
public class AdminInfo {
    @NonNull
    private final Integer id; // Excluded from the required args constructor

    @NonNull
    private final String adminName;

    private final OffsetTime createdAt;
    private final OffsetTime updatedAt;
}
