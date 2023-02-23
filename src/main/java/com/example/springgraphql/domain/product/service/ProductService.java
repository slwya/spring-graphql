package com.example.springgraphql.domain.product.service;

import com.example.springgraphql.domain.product.dto.ProductInput;
import com.example.springgraphql.domain.product.entity.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * <pre>
 * 상품 관련 service
 * </pre>
 */

@Service
public class ProductService {

    /**
     * 상품 조회
     * @param productCode 상품코드
     * @return 상품 데이터
     */
    public Product productByCode(Long productCode) {
        Product product = new Product(1L, "1", 1);
        return product;
    }

    /**
     * 상품리스트 조회
     * @return 상품 리스트 데이터
     */
    public ArrayList<Product> products() {
        ArrayList<Product> productList = new ArrayList<>();
        return productList;
    }

    /**
     * 상품 입력
     * @param productInput dto
     * @return 입력 결과
     */
    public Boolean insertProduct(ProductInput productInput) {
        return true;
    }

    /**
     * 상품 삭제
     * @param productCode 상품코드
     * @return 삭제 결과
     */
    public Boolean deleteProduct(Long productCode) {
        return true;
    }
}
