package org.edem.productmanagement.service;

import org.edem.productmanagement.dto.ResponseMessage;
import org.edem.productmanagement.dto.product.ProductResponse;
import org.edem.productmanagement.dto.product.CreateProductRequest;
import org.edem.productmanagement.dto.product.UpdateProductRequest;
import org.springframework.data.domain.Page;

public interface ProductService {
    ResponseMessage createProduct(CreateProductRequest request);

    Page<ProductResponse> getAllProducts(int page, int size, String direction , String sortBy);

    ResponseMessage updateProduct(Long id, UpdateProductRequest request);

    ResponseMessage deleteProduct (Long id);

    Page<ProductResponse> search(String keyword, int page, int size, String direction , String sortBy);
}
