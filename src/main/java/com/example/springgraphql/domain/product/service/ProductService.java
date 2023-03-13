package com.example.springgraphql.domain.product.service;

import com.example.springgraphql.domain.product.dto.ProductInput;
import com.example.springgraphql.domain.product.entity.Product;
import com.example.springgraphql.domain.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <pre>
 * 상품 관련 service
 * </pre>
 */

@Service
public class ProductService {

    private final ProductCircuitBreakerService productCircuitBreakerService;

    private final ProductRepository productRepository;

    public ProductService(ProductCircuitBreakerService productCircuitBreakerService, ProductRepository productRepository) {
        this.productCircuitBreakerService = productCircuitBreakerService;
        this.productRepository = productRepository;
    }

    /**
     * 상품 조회
     * @param productCode 상품코드
     * @return 상품 데이터
     */
    public Product productByCode(Long productCode) {
        return productCircuitBreakerService.productByCode(productCode);
    }

    /**
     * 상품리스트 조회
     * @return 상품 리스트 데이터
     */
    public List<Product> products() {
        return productCircuitBreakerService.productList();
    }

    /**
     * 상품 입력
     * @param productInput dto
     * @return 입력 결과
     */
    public Boolean insertProduct(ProductInput productInput) {
        productRepository.save(new Product(productInput));
        return true;
    }

    /**
     * 상품 삭제
     * @param productCode 상품코드
     * @return 삭제 결과
     */
    public Boolean deleteProduct(Long productCode) {
        productRepository.deleteById(productCode);
        return true;
    }
}
