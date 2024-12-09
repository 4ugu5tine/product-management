package org.edem.productmanagement.service;

import org.edem.productmanagement.dto.ProductResponse;
import org.edem.productmanagement.dto.CreateProductRequest;
import org.edem.productmanagement.dto.UpdateProductRequest;
import org.edem.productmanagement.entities.Product;
import org.springframework.data.domain.Page;

public interface ProductService {
    Product createProduct(CreateProductRequest request);

    Page<ProductResponse> getAllProducts(int page, int size);

    void updateProduct(Long id, UpdateProductRequest request);

    void deleteProduct (Long id);


}
