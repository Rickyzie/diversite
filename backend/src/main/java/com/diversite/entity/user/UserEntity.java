package com.diversite.entity.user;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class UserEntity {
    private Integer id;
    private String name;
    private String email;
    private String passwordHash;
    private String phoneNumber;
    private String address;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
