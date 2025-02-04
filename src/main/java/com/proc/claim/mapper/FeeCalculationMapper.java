package com.proc.claim.mapper;

import com.proc.claim.model.dto.FeeCalculationDTO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface FeeCalculationMapper {
    
    // 수가 계산 결과 조회
    FeeCalculationDTO selectFeeCalculation(String claimId, String claimDetailId);
    
    // 청구별 수가 계산 결과 목록 조회
    List<FeeCalculationDTO> selectClaimFeeCalculations(String claimId);
    
    // 수가 계산 결과 등록
    int insertFeeCalculation(FeeCalculationDTO feeCalculationDTO);
    
    // 수가 계산 결과 수정
    int updateFeeCalculation(FeeCalculationDTO feeCalculationDTO);
}