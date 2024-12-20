package org.edem.productmanagement.dto.categoty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import static org.edem.productmanagement.utils.Validator.*;

public record CreateCategoryRequest(
        @NotBlank(message = FIELD_IS_REQUIRED)
        @NotNull(message = FIELD_IS_REQUIRED)
        String categoryName,

        Long parentId,
        Long leftId,
        Long rightId) {
}
