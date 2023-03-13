package com.example.springgraphql.domain.review.service;

import com.example.springgraphql.domain.review.dto.ReviewInput;
import com.example.springgraphql.domain.review.entity.Review;
import com.example.springgraphql.domain.review.repository.ReviewRepository;
import org.springframework.stereotype.Service;

/**
 * <pre>
 * 상품평 관련 service
 * </pre>
 */
@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    /**
     * 상품평 조회
     * @param productCode 상품 코드
     * @return 상품평 데이터
     */
    public Review reviewByProductCode(Long productCode) {
        return reviewRepository.findByProductCode(productCode)
                .orElseGet(Review::new);
    }

    /**
     * 상품평 입력
     * @param reviewInput 상품평input
     * @return 입력 결과
     */
    public boolean insertReview(ReviewInput reviewInput) {
        reviewRepository.saveAndFlush(new Review(reviewInput));
        return true;
    }

    /**
     * 상품평 삭제
     * @param productcode 상품 코드
     * @return 삭제 결과
     */
    public boolean deleteReview(Long productcode) {
        reviewRepository.deleteByProductCode(productcode);
        return true;
    }
}
