package com.diversite.enumeration;

import lombok.Getter;

@Getter
public enum AdminPrivilege {
    NORMAL_ADMIN_PRIVILEGE("NORMAL_ADMIN_PRIVILEGE");
    private final String privilege;
    // Constructor
    AdminPrivilege(String privilege) {
        this.privilege = privilege;
    }

}
