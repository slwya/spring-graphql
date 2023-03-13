package com.example.springgraphql.domain.product.repository;

import com.example.springgraphql.domain.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <pre>
 * product jpa
 * </pre>
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
