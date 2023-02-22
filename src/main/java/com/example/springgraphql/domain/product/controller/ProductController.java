package com.example.springgraphql.domain.product.controller;

import com.example.springgraphql.domain.product.dto.ProductInput;
import com.example.springgraphql.domain.product.entity.Product;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;


/**
 * <pre>
 * 상품 관련 controller
 * </pre>
 */

@Controller
public class ProductController {

    /**
     * 상품 조회
     *
     * @param code 상품 코드
     * @return 상품
     */
    @QueryMapping
    public Product productByCode(@Argument @Valid @Min(value = 1, message = "This cacheKey is not supported.") Long code) {
        Product product = new Product();
        return product;
    }

    /**
     * 상품리스트 조회
     *
     * @return 상품 리스트
     */
    @QueryMapping
    public ArrayList<Product> products() {
        ArrayList<Product> products = new ArrayList<>();

        return products;
    }

    /**
     * 상품 입력
     *
     * @param productInput productInput
     * @return 저장 결과
     */
    @MutationMapping
    public boolean insertProduct(@Argument("input") @Valid ProductInput productInput) {
        return false;
    }

    /**
     * 상품 삭제
     *
     * @param productCode 상품코드
     * @return 저장 결과
     */
    @MutationMapping
    public boolean deleteProduct(@Argument @Valid @Min(value = 1, message = "code is min 1") Long productCode) {
        return false;
    }
}
