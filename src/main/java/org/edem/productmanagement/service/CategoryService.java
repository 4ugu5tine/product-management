package org.edem.productmanagement.service;

import org.edem.productmanagement.dto.ResponseMessage;
import org.edem.productmanagement.dto.categoty.CategoryResponse;
import org.edem.productmanagement.dto.categoty.CreateCategoryRequest;
import org.edem.productmanagement.dto.product.ProductResponse;
import org.springframework.data.domain.Page;

public interface CategoryService {
    ResponseMessage createCategory(CreateCategoryRequest request);
    Page<CategoryResponse> getAllCategories(int page, int size);
    ResponseMessage deleteCategory(Long id);

    Page<ProductResponse> getCategoryProducts(Long id, int page, int size, String direction , String sortBy);
}
