package com.example.springgraphql.domain.product.service;

import com.example.springgraphql.domain.product.dto.ProductInput;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    ProductService productService;



    /**
     * 상품 조회 테스트
     */
    @Test
    void productByCodeTest() {
        assertThat(productService.productByCode(1L)).isNotNull();
    }

    /**
     * 상품리스트 조회 테스트
     */
    @Test
    void productsTest() {
        assertThat(productService.products()).isNotEmpty();
    }

    /**
     * 상품입력 테스트
     */
    @Test
    void insertProductTest() {
        productService.insertProduct(new ProductInput(null, "11111", 11111));
    }

    /**
     * 상품삭제 테스트
     */
    @Test
    void deleteProductTest() {
        productService.deleteProduct(2L);
    }
}
