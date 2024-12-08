package org.edem.productmanagement.service;

import org.edem.productmanagement.dto.CreateProductRequest;
import org.edem.productmanagement.entities.Product;
import org.springframework.data.domain.Page;

public interface ProductService {
    Product createProduct(CreateProductRequest request);
    Page<Product> getAllProducts(int page, int size);



}
