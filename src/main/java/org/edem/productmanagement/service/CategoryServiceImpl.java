package org.edem.productmanagement.service;

import lombok.AllArgsConstructor;
import org.edem.productmanagement.dto.CreateCategoryRequest;
import org.edem.productmanagement.entities.Category;
import org.edem.productmanagement.repository.CategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void createCategory(CreateCategoryRequest request) {
        Category category = new Category(request.categoryName());
        categoryRepository.save(category);
    }

    @Override
    public Page<Category> getAllCategories(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return categoryRepository.findAll(pageRequest);
    }

}
