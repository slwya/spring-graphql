package com.example.springgraphql.domain.review.controller;

import com.example.springgraphql.domain.review.dto.ReviewInput;
import com.example.springgraphql.domain.review.entity.Review;
import com.example.springgraphql.domain.review.service.ReviewService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;



/**
 * <pre>
 * 리뷰 관련 controller
 * </pre>
 */

@Controller
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    /**
     * 리뷰 조회
     *
     * @param productCode 상품 코드
     * @return 리뷰
     */
    @QueryMapping
    public Review reviewByProductCode(@Argument @Valid @Min(value = 1, message = "code is min 1") Long productCode) {
        return reviewService.reviewByProductCode(productCode);
    }

    /**
     * 리뷰 입력
     *
     * @param reviewInput productInput
     * @return 저장 결과
     */
    @MutationMapping
    public boolean insertReview(@Argument("input") @Valid ReviewInput reviewInput) {
        return reviewService.insertReview(reviewInput);
    }

    /**
     * 리뷰 삭제
     * @param productCode 상품 코드
     * @return 삭제 결과
     */
    @MutationMapping
    public boolean deleteReview(@Argument @Valid @Min(value = 1, message = "code is min 1") Long productCode) {
        return reviewService.deleteReview(productCode);
    }
}
