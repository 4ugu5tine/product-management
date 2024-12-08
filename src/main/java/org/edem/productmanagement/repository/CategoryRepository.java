package org.edem.productmanagement.repository;

import org.edem.productmanagement.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CategoryRepository extends JpaRepository<Category, Long> {

//    @Query("select s from Category s where s.name = :name")
    Optional<Category> findByNameIgnoreCase (String categoryName);

}
