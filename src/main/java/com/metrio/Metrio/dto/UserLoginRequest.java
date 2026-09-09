package com.metrio.Metrio.dto;

public record UserLoginRequest(
        String email,
        String password
) {
}
