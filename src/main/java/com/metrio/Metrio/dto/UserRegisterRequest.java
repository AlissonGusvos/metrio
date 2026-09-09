package com.metrio.Metrio.dto;

import org.springframework.context.annotation.Bean;

public record UserRegisterRequest(
        String username,
        String email,
        String password
) {
}
