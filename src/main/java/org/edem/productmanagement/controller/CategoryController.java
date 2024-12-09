package org.edem.productmanagement.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.edem.productmanagement.dto.CategoryResponse;
import org.edem.productmanagement.dto.CreateCategoryRequest;
import org.edem.productmanagement.dto.ProductResponse;
import org.edem.productmanagement.entities.Category;
import org.edem.productmanagement.service.CategoryServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
    private final CategoryServiceImpl categoryService;

    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @Operation(summary = "Create category")
    @PostMapping("/new-category")
    public ResponseEntity<Category> createCategory(@RequestBody CreateCategoryRequest request){
        categoryService.createCategory(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Get all Categories")
    @GetMapping("/all")
    public Page<CategoryResponse> getCategories(@RequestParam(defaultValue = "0") int page,
                                                @RequestParam(defaultValue = "10") int size){
        return categoryService.getAllCategories(page,size);
    }

    @Operation(summary = "Delete category")
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id){
         categoryService.deleteCategory(id);
    }

    @Operation(summary = "Get all products belonging to a category")
    @GetMapping("/{id}/products")
    public Page<ProductResponse> getCategoryProducts(@PathVariable("id")Long id,
                                                    @RequestParam(defaultValue = "0") int page,
                                                     @RequestParam(defaultValue = "10") int size){
        return categoryService.getCategoryProducts(id, page,size);
    }

}
