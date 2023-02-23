package com.example.springgraphql.domain.product.service;

import com.example.springgraphql.domain.product.entity.Product;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class ProductCircuitBreakerService {
    Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 상품 조회
     * @param productCode 상품코드
     * @return 상품 데이터
     */
    @CircuitBreaker(name = "circuitBreaker", fallbackMethod = "productFallback")
    public Product productByCode(Long productCode) {
        Product product = new Product(1L, "1", 1);
        return product;
    }

    /**
     * 상품 조회 - 서킷브레이커
     * @param productCode 상품코드
     * @return 상품 데이터
     */
    public Product productFallback(Long productCode, Throwable throwable) {
        logger.info("[getCacheFallback] - cacheKey: {}, throwable message: {}", productCode, throwable.getMessage());
        Product product = new Product(2L, "2", 2);
        return product;
    }
}
