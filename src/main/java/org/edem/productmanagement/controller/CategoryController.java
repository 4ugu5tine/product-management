package org.edem.productmanagement.controller;

import org.edem.productmanagement.dto.CreateCategoryRequest;
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

    @PostMapping("/new-category")
    public ResponseEntity<Category> createCategory(@RequestBody CreateCategoryRequest request){
        categoryService.createCategory(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public Page<Category> getCategories(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
        return categoryService.getAllCategories(page,size);
    }

}
