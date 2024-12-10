package org.edem.productmanagement.dto.product;

import java.math.BigDecimal;

public interface ProductResponse {
    String getName();
    String getDescription();
    BigDecimal getPrice();
}
