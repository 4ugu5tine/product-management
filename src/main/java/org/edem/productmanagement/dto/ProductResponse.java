package org.edem.productmanagement.dto;

import java.math.BigDecimal;

public interface ProductResponse {
    String getName();
    String getDescription();
    BigDecimal getPrice();
}
