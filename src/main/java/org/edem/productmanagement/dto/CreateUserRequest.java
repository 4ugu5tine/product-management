package org.edem.productmanagement.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import static org.edem.productmanagement.utils.Validator.FIELD_IS_REQUIRED;

public record CreateUserRequest(
        @NotNull(message = FIELD_IS_REQUIRED)
        @NotBlank(message = FIELD_IS_REQUIRED)
        String firstName,

        @NotNull(message = FIELD_IS_REQUIRED)
        @NotBlank(message = FIELD_IS_REQUIRED)
        String lastName,

        @NotNull(message = FIELD_IS_REQUIRED)
        @NotBlank(message = FIELD_IS_REQUIRED)
        String email,

        @NotNull(message = FIELD_IS_REQUIRED)
        @NotBlank(message = FIELD_IS_REQUIRED)
        String password,

        @NotNull(message = FIELD_IS_REQUIRED)
        @NotBlank(message = FIELD_IS_REQUIRED)
        String phone
) {

}