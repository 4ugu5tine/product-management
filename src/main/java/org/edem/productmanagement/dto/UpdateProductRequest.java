package org.edem.productmanagement.dto;




public record UpdateProductRequest(

        String productName,

        String description,

        double price,

        String categoryName
) {
}
