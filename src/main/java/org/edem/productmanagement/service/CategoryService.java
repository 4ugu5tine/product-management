package org.edem.productmanagement.service;

import org.edem.productmanagement.dto.CategoryResponse;
import org.edem.productmanagement.dto.CreateCategoryRequest;
import org.edem.productmanagement.dto.ProductResponse;
import org.edem.productmanagement.entities.Product;
import org.springframework.data.domain.Page;

public interface CategoryService {
    void createCategory(CreateCategoryRequest request);
    Page<CategoryResponse> getAllCategories(int page, int size);
    void deleteCategory(Long id);

    Page<ProductResponse> getCategoryProducts(Long id, int page, int size);
}
