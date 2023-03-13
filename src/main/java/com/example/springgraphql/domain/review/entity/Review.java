package com.example.springgraphql.domain.review.entity;

import com.example.springgraphql.domain.review.dto.ReviewInput;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * review entity
 */

@Entity
@Table(name = "REVIEW")
public class Review {
    // 리뷰 코드
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
    private Long reviewCode;

    // 상품 코드
    private Long productCode;

    // 내용
    private String content;

    // 점수
    private int score;

    public Review() {

    }

    public Review(ReviewInput reviewInput) {
        this.reviewCode = reviewInput.reviewCode();
        this.productCode = reviewInput.productCode();
        this.content = reviewInput.content();
        this.score = reviewInput.score();
    }
}
