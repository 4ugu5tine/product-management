package org.edem.productmanagement.dto.product;




public record UpdateProductRequest(

        String productName,

        String description,

        double price,

        String categoryName
) {
}
