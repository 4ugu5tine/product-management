package org.edem.productmanagement.dto.auth;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import static org.edem.productmanagement.utils.Validator.*;

public record SignUpRequest(
        @NotNull(message = FIRST_NAME_NOT_NULL)
        @NotBlank(message = FIRST_NAME_NOT_BLANK)
        String firstName,

        @NotNull(message = LAST_NAME_NOT_NULL)
        @NotBlank(message = LAST_NAME_NOT_BLANK)
        String lastName,

        @NotNull(message = EMAIL_NOT_NULL)
        @NotBlank(message = EMAIL_NOT_BLANK)
        String email,

        @NotNull(message = PASSWORD_NOT_NULL)
        @NotBlank(message = PASSWORD_NOT_BLANK)
        String password,

        @NotNull(message = PHONE_NOT_NULL)
        @NotBlank(message = PHONE_NOT_BLANK)
        String phone
) {

}