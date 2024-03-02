package com.diversite.entity.admin;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.OffsetTime;
import java.time.ZonedDateTime;


@Data
@RequiredArgsConstructor
public class AdminEntity {
    private Integer id; // Excluded from the required args constructor

    @NonNull
    private final String adminName;

    @NonNull
    private final String passwordHash;

    private OffsetTime createdAt;
    private OffsetTime updatedAt;
}
