package org.edem.productmanagement.service;

import lombok.extern.slf4j.Slf4j;
import org.edem.productmanagement.dto.CategoryResponse;
import org.edem.productmanagement.dto.CreateCategoryRequest;
import org.edem.productmanagement.dto.ProductResponse;
import org.edem.productmanagement.entities.Category;
import org.edem.productmanagement.exception.CategoryNotFoundException;
import org.edem.productmanagement.repository.CategoryRepository;
import org.edem.productmanagement.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;

    private final ProductRepository productRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void createCategory(CreateCategoryRequest request) {
        Category category = new Category(request.categoryName());

        categoryRepository.save(category);
    }

    @Override
    public Page<CategoryResponse> getAllCategories(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return categoryRepository.findAllCategories(pageRequest);
    }

    @Override
    public void deleteCategory(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(()-> new CategoryNotFoundException("Category not found"));
        categoryRepository.delete(category);
        log.info("deleted category with id: {}",id);
    }

    @Override
    public Page<ProductResponse> getCategoryProducts(Long categoryId, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        log.info("found {} entries for category", productRepository.findAllProductsByCategoryId(categoryId,pageRequest).getTotalElements());
        return productRepository.findAllProductsByCategoryId(categoryId, pageRequest);
    }
}
