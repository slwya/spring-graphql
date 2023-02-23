package com.example.springgraphql.domain.product.controller;

import com.example.springgraphql.domain.product.dto.ProductInput;
import com.example.springgraphql.domain.product.entity.Product;
import com.example.springgraphql.domain.product.service.ProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
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
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * 상품 조회
     *
     * @param productCode 상품 코드
     * @return 상품
     */
    @QueryMapping
    public Product productByCode(@Argument @Valid @Positive(message = "1이상 입력") Long productCode) {
        return productService.productByCode(productCode);
    }

    /**
     * 상품리스트 조회
     *
     * @return 상품 리스트
     */
    @QueryMapping
    public ArrayList<Product> products() {
        return productService.products();
    }

    /**
     * 상품 입력
     *
     * @param productInput productInput
     * @return 저장 결과
     */
    @MutationMapping
    public boolean insertProduct(@Argument("input") @Valid ProductInput productInput) {
        return productService.insertProduct(productInput);
    }

    /**
     * 상품 삭제
     *
     * @param productCode 상품코드
     * @return 저장 결과
     */
    @MutationMapping
    public boolean deleteProduct(@Argument @Valid @Min(value = 1, message = "1이상 입력") Long productCode) {
        return productService.deleteProduct(productCode);
    }
}
