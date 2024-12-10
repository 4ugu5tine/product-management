package org.edem.productmanagement.dto.product;

import lombok.Builder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import static org.edem.productmanagement.utils.Validator.*;
@Builder
public record CreateProductRequest(
        @NotNull(message = FIELD_IS_REQUIRED)
        @NotBlank(message = FIELD_IS_REQUIRED)
        String productName,

        @NotNull(message = FIELD_IS_REQUIRED)
        @NotBlank(message = FIELD_IS_REQUIRED)
        String description,

        @NotNull(message = FIELD_IS_REQUIRED)
        @NotBlank(message = FIELD_IS_REQUIRED)
        double price,

        @NotNull(message = FIELD_IS_REQUIRED)
        @NotBlank(message = FIELD_IS_REQUIRED)
        String categoryName
) {
}
