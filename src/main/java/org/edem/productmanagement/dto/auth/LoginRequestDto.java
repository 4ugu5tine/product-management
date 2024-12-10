package org.edem.productmanagement.dto.auth;

public record LoginRequestDto(
        String email,
        String password
) {
}
