package org.edem.productmanagement.repository;

import org.edem.productmanagement.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Retention;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
