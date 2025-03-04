//package org.edem.productmanagement.service;
//
//import org.edem.productmanagement.dto.ResponseMessage;
//import org.edem.productmanagement.dto.categoty.CreateCategoryRequest;
//import org.edem.productmanagement.repository.CategoryRepository;
//import org.edem.productmanagement.trees.CategoryTreeNode;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import static org.edem.productmanagement.utils.Validator.CATEGORY_CREATED;
//import static org.junit.jupiter.api.Assertions.*;
//
//@ExtendWith(MockitoExtension.class)
//class CategoryServiceImplTest {
//    @Mock
//    private CategoryRepository categoryRepository;
//
//    @Mock
//    private CategoryTreeNode categoryTreeNode;
//
//    @InjectMocks
//    private CategoryServiceImpl categoryService;
//
//
//    @Test
//    void createCategory() {
//
//        CreateCategoryRequest request = CreateCategoryRequest
//                .builder()
//                .categoryName("music")
//                .build();
//
//        ResponseMessage responseMessage = categoryService.createCategory(request);
//
//        assertEquals(responseMessage.message(), CATEGORY_CREATED);
//
//
//    }
//
////    @Test
////    void getAllCategories() {
////    }
////
////    @Test
////    void deleteCategory() {
////    }
////
////    @Test
////    void getCategoryProducts() {
////    }
//}