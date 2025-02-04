package com.proc.claim.service;

import com.proc.claim.mapper.ReviewMapper;
import com.proc.claim.model.dto.ReviewDTO;
import com.proc.claim.exception.CustomException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReviewService {
    
    private final ReviewMapper reviewMapper;

    @Transactional(readOnly = true)
    public ReviewDTO getReviewResult(String claimId, String claimDetailId) {
        return reviewMapper.selectReviewResult(claimId, claimDetailId);
    }

    @Transactional(readOnly = true)
    public List<ReviewDTO> getClaimReviews(String claimId) {
        return reviewMapper.selectClaimReviews(claimId);
    }

    @Transactional
    public void processReview(ReviewDTO reviewDTO) {
        try {
            if (reviewMapper.selectReviewResult(reviewDTO.getClaimId(), reviewDTO.getClaimDetailId()) == null) {
                reviewMapper.insertReviewResult(reviewDTO);
            } else {
                reviewMapper.updateReviewResult(reviewDTO);
            }
        } catch (Exception e) {
            log.error("Error processing review: {} - {}", reviewDTO.getClaimId(), reviewDTO.getClaimDetailId(), e);
            throw new CustomException("REVIEW_PROCESS_ERROR", "심사 처리 중 오류가 발생했습니다.");
        }
    }
}