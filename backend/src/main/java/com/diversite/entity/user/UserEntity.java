package com.diversite.entity.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.OffsetTime;
import java.time.ZonedDateTime;


@Data
@RequiredArgsConstructor
public class UserEntity {
    private Integer id; // Excluded from the required args constructor

    @NonNull
    private final String name;

    @NonNull
    private final String email;

    @NonNull
    private final String passwordHash;

    private String phoneNumber;
    private String address;
    private OffsetTime createdAt;
    private OffsetTime updatedAt;
}
