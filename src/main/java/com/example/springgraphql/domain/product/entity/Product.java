package com.example.springgraphql.domain.product.entity;

/**
 * <pre>
 * product entity
 * </pre>
 */
public record Product(
        // 상품 코드
        Long productCode,

        // 상품 명
        String productName,

        // 상품 가격
        int price) {
}
