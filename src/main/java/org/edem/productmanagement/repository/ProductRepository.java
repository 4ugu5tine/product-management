package org.edem.productmanagement.repository;

import org.edem.productmanagement.dto.product.ProductResponse;
import org.edem.productmanagement.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p")
    Page<ProductResponse> findAllProducts(Pageable pageable);

    @Query("select p from Product p where p.category.id = :categoryId")
    Page<ProductResponse> findAllProductsByCategoryId(@Param("categoryId") Long categoryId, Pageable pageable1);

    @Query("select p from Product p where lower(p.name) like lower(concat('%', :keyword, '%')) or lower(p.description) like lower(concat('%', :keyword, '%'))")
    Page<ProductResponse> searchProduct(@Param("keyword") String keyword, Pageable pageable);

}