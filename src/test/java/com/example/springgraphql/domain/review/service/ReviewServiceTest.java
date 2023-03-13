package com.example.springgraphql.domain.review.service;

import com.example.springgraphql.domain.review.dto.ReviewInput;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ReviewServiceTest {
    @Autowired
    ReviewService reviewService;

    /**
     * 상품평 조회
     */
    @Test
    void reviewByProductCodeTest() {
        assertThat(reviewService.reviewByProductCode(1L)).isNotNull();
    }

    /**
     * 상품평 입력
     */
    @Test
    void insertReviewTest() {
        reviewService.insertReview(new ReviewInput(9L,null,"123123",3));
    }

    /**
     * 상품평 삭제
     */
    @Test
    void deleteReviewTest() {
        reviewService.deleteReview(1L);
    }
}
