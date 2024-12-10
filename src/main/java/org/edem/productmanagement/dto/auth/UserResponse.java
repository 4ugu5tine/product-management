package org.edem.productmanagement.dto.auth;

import lombok.Builder;
import org.edem.productmanagement.entities.Roles;

@Builder
public record UserResponse(
        String name,

        String email,

        Roles role
) {
}
