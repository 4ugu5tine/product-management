package org.edem.productmanagement.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.edem.productmanagement.dto.ResponseMessage;
import org.edem.productmanagement.dto.categoty.CategoryResponse;
import org.edem.productmanagement.dto.categoty.CreateCategoryRequest;
import org.edem.productmanagement.dto.product.ProductResponse;
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
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseMessage createCategory(@RequestBody CreateCategoryRequest request){
        return categoryService.createCategory(request);
    }

    @Operation(summary = "Get all Categories")
    @GetMapping("/all")
    public Page<CategoryResponse> getCategories(@RequestParam(defaultValue = "0") int page,
                                                @RequestParam(defaultValue = "10") int size,
                                                @RequestParam(defaultValue = "asc") String direction,
                                                @RequestParam(defaultValue = "name") String sortBy){
        return categoryService.getAllCategories(page,size,direction,sortBy);
    }

    @Operation(summary = "Delete category")
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseMessage delete(@PathVariable("id") Long id){
         return categoryService.deleteCategory(id);
    }

    @Operation(summary = "Get all products belonging to a category")
    @GetMapping("/{id}/products")
    public Page<ProductResponse> getCategoryProducts(@PathVariable("id")Long id,
                                                    @RequestParam(defaultValue = "0") int page,
                                                     @RequestParam(defaultValue = "10") int size,
                                                     @RequestParam(defaultValue = "asc") String direction,
                                                     @RequestParam(defaultValue = "name") String sortBy){
        return categoryService.getCategoryProducts(id, page,size, direction,sortBy);
    }



}
