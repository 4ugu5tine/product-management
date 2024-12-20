package org.edem.productmanagement.service;

import org.edem.productmanagement.dto.ResponseMessage;
import org.edem.productmanagement.dto.categoty.CreateCategoryRequest;
import org.edem.productmanagement.dto.product.CreateProductRequest;
import org.edem.productmanagement.dto.product.ProductResponse;
import org.edem.productmanagement.entities.Category;
import org.edem.productmanagement.entities.Product;

import static org.edem.productmanagement.utils.Validator.PRODUCT_CREATED;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.edem.productmanagement.repository.CategoryRepository;
import org.edem.productmanagement.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;


@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private CategoryRepository categoryRepository;


    @Test
    void shouldCreateProduct() {
        Category category = new Category();
        category.setId(1L);
        category.setName("music");
        
        CreateProductRequest request = CreateProductRequest.builder()
                .productName("Closet")
                .price(23.6)
                .description("very quality")
                .categoryName("music")
                .build();


        ResponseMessage message = productService.createProduct(request);
        assertEquals(PRODUCT_CREATED, message.message());
    }
}