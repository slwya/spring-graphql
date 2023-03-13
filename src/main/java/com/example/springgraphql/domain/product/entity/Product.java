package com.example.springgraphql.domain.product.entity;

import com.example.springgraphql.domain.product.dto.ProductInput;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * <pre>
 * product entity
 * </pre>
 */
@Entity
@Table(name = "PRODUCT")
public class Product {
    // 상품 코드
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
    private Long productCode;

    // 상품 명
    private String productName;

    // 상품 가격
    private int price;

    public Product(ProductInput productInput) {
        this.productCode = productInput.productCode();
        this.productName = productInput.productName();
        this.price = productInput.price();
    }

    public Product() {

    }
}
