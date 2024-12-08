package org.edem.productmanagement.service;


import org.edem.productmanagement.dto.CreateProductRequest;
import org.edem.productmanagement.entities.Category;
import org.edem.productmanagement.entities.Product;
import org.edem.productmanagement.exception.CategoryNotFoundException;
import org.edem.productmanagement.repository.CategoryRepository;
import org.edem.productmanagement.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


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

        Product product = new Product(
                request.productName(),
                request.description(),
                request.price(),
                category
        );
        productRepository.save(product);
        return product;
    }

    @Override
    public Page<Product> getAllProducts(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return productRepository.findAll(pageRequest);
    }
}
