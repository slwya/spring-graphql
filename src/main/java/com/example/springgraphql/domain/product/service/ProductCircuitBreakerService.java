package com.example.springgraphql.domain.product.service;

import com.example.springgraphql.domain.product.entity.Product;
import com.example.springgraphql.domain.product.repository.ProductRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * 상품 관련 서킷브레이커
 * </pre>
 */
@Service
public class ProductCircuitBreakerService {
    Logger logger = LoggerFactory.getLogger(getClass());

    private final ProductRepository productRepository;

    public ProductCircuitBreakerService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * 상품 조회
     * @param productCode 상품코드
     * @return 상품 데이터
     */
    @CircuitBreaker(name = "circuitBreaker", fallbackMethod = "productFallback")
    public Product productByCode(Long productCode) {
        return productRepository.findById(productCode)
                .orElseGet(Product::new);
    }

    /**
     * 상품 조회 - 서킷브레이커
     * @param productCode 상품코드
     * @return 상품 데이터
     */
    public Product productFallback(Long productCode, Throwable throwable) {
        logger.info("[getCacheFallback] - productCode: {}, throwable message: {}", productCode, throwable.getMessage());
        return new Product();
    }

    /**
     * 상품리스트 조회
     * @return 상품리스트 데이터
     */
    @CircuitBreaker(name = "circuitBreaker", fallbackMethod = "productListFallback")
    public List<Product> productList() {
        return productRepository.findAll();
    }

    /**
     * 상품리스트 조회 - 서킷브레이커
     * @return 상품리스트 데이터
     */
    public ArrayList<Product> productListFallback(Throwable throwable) {
        logger.info("[productListFallback], throwable message: {}", throwable.getMessage());
        return new ArrayList<>();
    }
}
