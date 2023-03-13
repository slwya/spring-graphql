package com.example.springgraphql.domain.review.repository;

import com.example.springgraphql.domain.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * <pre>
 * review jpa
 * </pre>
 */

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    Optional<Review> findByProductCode(Long productCode);

    @Transactional
    void deleteByProductCode(Long productCode);
}
