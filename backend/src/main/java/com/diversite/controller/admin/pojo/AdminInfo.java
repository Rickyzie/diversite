package com.diversite.controller.admin.pojo;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AdminInfo {
    @NonNull
    String AdminName;
}
