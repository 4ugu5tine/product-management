package org.edem.productmanagement.service;

import org.edem.productmanagement.dto.CreateCategoryRequest;
import org.edem.productmanagement.entities.Category;
import org.springframework.data.domain.Page;

public interface CategoryService {
    void createCategory(CreateCategoryRequest request);
    Page<Category> getAllCategories(int page, int size);
}
