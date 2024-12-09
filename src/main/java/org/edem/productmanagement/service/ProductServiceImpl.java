package org.edem.productmanagement.service;


import lombok.extern.slf4j.Slf4j;
import org.edem.productmanagement.dto.ProductResponse;
import org.edem.productmanagement.dto.CreateProductRequest;
import org.edem.productmanagement.dto.UpdateProductRequest;
import org.edem.productmanagement.entities.Category;
import org.edem.productmanagement.entities.Product;
import org.edem.productmanagement.exception.CategoryNotFoundException;
import org.edem.productmanagement.exception.ProductNotFoundException;
import org.edem.productmanagement.repository.CategoryRepository;
import org.edem.productmanagement.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService{
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public ProductServiceImpl(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct( CreateProductRequest request) {
        Category category = categoryRepository.findByNameIgnoreCase(request.categoryName())
                .orElseThrow(()-> new CategoryNotFoundException("Category not found"));

        Product product = Product.builder()
                .name(request.productName())
                .category(category)
                .price(request.price())
                .createdAt(LocalDateTime.now())
                .build();
        productRepository.save(product);
        log.info("created product {} successfully", product.getName());
        return product;
    }

    @Override
    public Page<ProductResponse> getAllProducts(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<ProductResponse> products = productRepository.findAllProducts(pageRequest);
        log.info("Found {} entries",size);
        return products;
    }

    @Override
    public void updateProduct(Long id, UpdateProductRequest request) {
        Product product = productRepository.findById(id).orElseThrow(()-> new ProductNotFoundException("No product found"));

        if(request.productName() != null && !request.productName().isEmpty())
            product.setName(request.productName());

        if(request.price() > 0.00 )
            product.setPrice(request.price());

        if(request.description() != null && !request.description().isEmpty())
            product.setDescription(request.description());

        if(request.categoryName() != null && !request.categoryName().isEmpty()){
            Category category = categoryRepository.findByNameIgnoreCase(request.categoryName()).orElseThrow(()-> new CategoryNotFoundException("Could not find the Category"));
            product.setCategory(category);
        }

        productRepository.save(product);

        log.info("updated product {} successfully", product.getId());
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(()-> new ProductNotFoundException("Product not found"));
        productRepository.delete(product);
        log.info("deleted product {}", product.getName());
    }

}

