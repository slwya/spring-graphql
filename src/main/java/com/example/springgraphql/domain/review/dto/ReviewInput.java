package com.example.springgraphql.domain.review.dto;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public record ReviewInput(
       // 상품 코드
       @Positive(message = "1이상 입력")
       Long productCode,

       // 리뷰 코드
       Long reviewCode,

       // 내용
       String content,

       // 점수
       @PositiveOrZero(message = "0이상 입력")
       int score) {
}
