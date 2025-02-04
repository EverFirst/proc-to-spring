package com.proc.claim.mapper;

import com.proc.claim.model.dto.ReviewDTO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ReviewMapper {
    
    // 심사 결과 조회
    ReviewDTO selectReviewResult(String claimId, String claimDetailId);
    
    // 청구별 심사 결과 목록 조회
    List<ReviewDTO> selectClaimReviews(String claimId);
    
    // 심사 결과 등록
    int insertReviewResult(ReviewDTO reviewDTO);
    
    // 심사 결과 수정
    int updateReviewResult(ReviewDTO reviewDTO);
}