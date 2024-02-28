package com.diversite.enumeration;

import lombok.Getter;

@Getter
public enum UserPrivilege {
    NORMAL_USER_PRIVILEGE("NORMAL_USER_PRIVILEGE");
    private final String privilege;
    // Constructor
    UserPrivilege(String privilege) {
        this.privilege = privilege;
    }

}