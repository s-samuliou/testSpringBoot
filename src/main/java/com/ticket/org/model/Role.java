package com.ticket.org.model;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@RequiredArgsConstructor
public enum Role implements GrantedAuthority { //Интерфейс отвечает за роли польщователей в системе

    ADMIN("ADMIN"),
    USER("USER");

    private final String value;

    Role(String value) {
        this.value = value;
    }


    @Override
    public String getAuthority() {
        return null;
    }
}
