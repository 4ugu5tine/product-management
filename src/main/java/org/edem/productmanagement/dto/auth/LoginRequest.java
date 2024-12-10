package org.edem.productmanagement.dto.auth;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import static org.edem.productmanagement.utils.Validator.FIELD_IS_REQUIRED;

public record LoginRequest(
        @NotNull(message = FIELD_IS_REQUIRED)
        @NotBlank(message = FIELD_IS_REQUIRED)
        String email,

        @NotNull(message = FIELD_IS_REQUIRED)
        @NotBlank(message = FIELD_IS_REQUIRED)
        String password
) {
}
