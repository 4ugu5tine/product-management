package org.edem.productmanagement.service;


import lombok.extern.slf4j.Slf4j;
import org.edem.productmanagement.dto.ResponseMessage;
import org.edem.productmanagement.dto.product.ProductResponse;
import org.edem.productmanagement.dto.product.CreateProductRequest;
import org.edem.productmanagement.dto.product.UpdateProductRequest;
import org.edem.productmanagement.entities.Category;
import org.edem.productmanagement.entities.Product;
import org.edem.productmanagement.exception.CategoryNotFoundException;
import org.edem.productmanagement.exception.ProductNotFoundException;
import org.edem.productmanagement.repository.CategoryRepository;
import org.edem.productmanagement.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static org.edem.productmanagement.utils.Validator.*;

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
    public ResponseMessage createProduct(CreateProductRequest request) {
        Category category = categoryRepository.findByNameIgnoreCase(request.categoryName())
                .orElseThrow(()-> new CategoryNotFoundException("Category not found"));

        Product product = Product.builder()
                .name(request.productName())
                .category(category)
                .price(request.price())
                .description(request.description())
                .createdAt(LocalDateTime.now())
                .build();
        productRepository.save(product);
        log.info("created product {} successfully", product.getName());
        return new ResponseMessage(PRODUCT_CREATED);
    }

    @Override
    public Page<ProductResponse> getAllProducts(int page, int size, String direction, String sortBy) {
        Sort.Direction sortDirection = Sort.Direction.fromString(direction);
        PageRequest pageRequest = PageRequest.of(page, size,Sort.by(sortDirection, sortBy));
//        log.info("Found {} entries",products.getTotalElements());
        return productRepository.findAllProducts(pageRequest);
    }

    @Override
    public ResponseMessage updateProduct(Long id, UpdateProductRequest request) {
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
        return new ResponseMessage(UPDATE_SUCCESSFUL);
    }

    @Override
    public ResponseMessage deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(()-> new ProductNotFoundException("Product not found"));
        productRepository.delete(product);
        log.info("deleted product {}", product.getName());
        return new ResponseMessage(DELETE_PRODUCT_SUCCESSFULLY);
    }

    @Override
    public Page<ProductResponse> search(String keyword, int page, int size, String direction, String sortBy) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<ProductResponse> products = productRepository.searchProduct(keyword, pageRequest);

        log.info("Found {} entries", products.getTotalElements());
        return products;
    }

}

