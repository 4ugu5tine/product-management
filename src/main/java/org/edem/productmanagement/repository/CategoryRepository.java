package org.edem.productmanagement.repository;

import org.edem.productmanagement.dto.categoty.CategoryResponse;
import org.edem.productmanagement.entities.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("select s from Category s where s.name = :name")
    Optional<Category> findByNameIgnoreCase (@Param("name") String name);

    @Query("select c from Category c")
    Page<CategoryResponse> findAllCategories(Pageable pageable);

}
