package com.diversite.entity.user;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.OffsetTime;

@Data
@RequiredArgsConstructor
public class UserInfo {
    private Integer id;

    @NonNull
    private final String name;

    @NonNull
    private final String email;

    private String phoneNumber;
    private String address;
    private OffsetTime createdAt;
    private OffsetTime updatedAt;
}
