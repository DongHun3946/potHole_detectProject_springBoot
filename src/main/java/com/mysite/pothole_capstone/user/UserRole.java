package com.mysite.pothole_capstone.user;

import lombok.Getter;

@Getter
public enum UserRole {
    MANAGER("ROLE_MANAGER"),
    USER("ROLE_USER");

    UserRole(String value){
        this.value = value;
    }
    private final String value;
}
