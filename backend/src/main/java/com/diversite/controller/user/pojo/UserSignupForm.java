package com.diversite.controller.user.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserSignupForm {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
