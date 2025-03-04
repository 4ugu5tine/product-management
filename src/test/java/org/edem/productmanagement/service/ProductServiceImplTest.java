//package org.edem.productmanagement.service;
//
//import org.edem.productmanagement.dto.ResponseMessage;
//import org.edem.productmanagement.dto.product.CreateProductRequest;
//import org.edem.productmanagement.entities.Category;
//
//import static org.edem.productmanagement.utils.Validator.PRODUCT_CREATED;
//import static org.junit.jupiter.api.Assertions.*;
//
//import org.edem.productmanagement.repository.CategoryRepository;
//import org.edem.productmanagement.repository.ProductRepository;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//
//@ExtendWith(MockitoExtension.class)
//class ProductServiceImplTest {
//    @Mock
//    private ProductRepository productRepository;
//
//    @InjectMocks
//    private ProductServiceImpl productService;
//
//    @Mock
//    private CategoryRepository categoryRepository;
//
//
//    @Test
//    void shouldCreateProduct() {
//        Category category = new Category();
//        category.setId(1L);
//        category.setName("music");
//
//        CreateProductRequest request = CreateProductRequest.builder()
//                .productName("Closet")
//                .price(23.6)
//                .description("very quality")
//                .categoryName("music")
//                .build();
//
//
//        ResponseMessage message = productService.createProduct(request);
//        assertEquals(PRODUCT_CREATED, message.message());
//    }
//}