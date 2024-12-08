package org.edem.productmanagement.dto;

import lombok.Builder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

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
        BigDecimal price,

        @NotNull(message = FIELD_IS_REQUIRED)
        @NotBlank(message = FIELD_IS_REQUIRED)
        String categoryName
) {
}
