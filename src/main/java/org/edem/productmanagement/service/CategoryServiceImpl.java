package org.edem.productmanagement.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.edem.productmanagement.dto.ResponseMessage;
import org.edem.productmanagement.dto.categoty.CategoryResponse;
import org.edem.productmanagement.dto.categoty.CreateCategoryRequest;
import org.edem.productmanagement.dto.product.ProductResponse;
import org.edem.productmanagement.entities.Category;
import org.edem.productmanagement.exception.CategoryNotFoundException;
import org.edem.productmanagement.repository.CategoryRepository;
import org.edem.productmanagement.repository.ProductRepository;
import org.edem.productmanagement.trees.CategoryTreeNode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import static org.edem.productmanagement.utils.Validator.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    private final ProductRepository productRepository;

    private final CategoryTreeNode categoryTreeNode;


    @Override
    public ResponseMessage createCategory(CreateCategoryRequest request) {
//        Category category = new Category(request.categoryName());


        // Fetch categories from the database
        var categories = categoryRepository.findAll();

        // Build the binary tree from the categories in the database
        categoryTreeNode.buildTree(categories);

        Category category = new Category();
        category.setName(request.categoryName().toLowerCase());

        // If the category is a root node (no parent), create a new tree
        if (request.parentId() == null) {
            // Root node, we can create a new tree or append it to an existing root
            categoryRepository.save(category);
            return new ResponseMessage(CATEGORY_CREATED);  // Root node is saved directly
        }

        // If it has a parent, check and insert accordingly
        if (request.parentId() != null) {
            Category parentCategory = categoryRepository.findById(request.parentId()).orElse(null);

            if (parentCategory == null) {
                throw new CategoryNotFoundException(CATEGORY_NOT_FOUND);
            }

            // Check if the parent category already has two children
            if (categoryTreeNode.hasTwoChildren(parentCategory)) {
                throw new RuntimeException("The parent category already has two children.");
            }

            // Check if left position is occupied
            if (request.leftId() != null && categoryTreeNode.isPositionOccupied(parentCategory, true)) {
                throw new RuntimeException("The left position is already occupied.");
            }

            // Check if right position is occupied
            if (request.rightId() != null && categoryTreeNode.isPositionOccupied(parentCategory, false)) {
                throw new RuntimeException("The right position is already occupied.");
            }

            // Set parent and positions if applicable
            category.setParent(parentCategory);
            if (request.leftId() != null) {
                Category leftChild = categoryRepository.findById(request.leftId()).orElse(null);
                category.setLeftPosition(leftChild);
            }
            if (request.rightId() != null) {
                Category rightChild = categoryRepository.findById(request.rightId()).orElse(null);
                category.setRightPosition(rightChild);
            }
        }

        categoryRepository.save(category);
        return new ResponseMessage(CATEGORY_CREATED);
    }

    @Override
    public Page<CategoryResponse> getAllCategories(int page, int size, String direction, String sortBy) {
        Sort.Direction sortDirection = Sort.Direction.fromString(direction);
        PageRequest pageRequest = PageRequest.of(page, size,Sort.by(sortDirection, sortBy));
        return categoryRepository.findAllCategories(pageRequest);
    }

    @Override
    public ResponseMessage deleteCategory(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(()-> new CategoryNotFoundException("Category not found"));
        category.setDeleted(true);
        categoryRepository.save(category);
        log.info("deleted category with id: {}",id);
        return  new ResponseMessage(CATEGORY_DELETED_SUCCESSFULLY);
    }

    @Override
    public Page<ProductResponse> getCategoryProducts(Long categoryId, int page, int size, String direction, String sortBy) {
        Sort.Direction sortDirection = Sort.Direction.fromString(direction);
        PageRequest pageRequest = PageRequest.of(page, size,Sort.by(sortDirection, sortBy));
        log.info("found {} entries for category", productRepository.findAllProductsByCategoryId(categoryId,pageRequest).getTotalElements());
        return productRepository.findAllProductsByCategoryId(categoryId, pageRequest);
    }
}
