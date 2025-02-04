package com.proc.claim.service;

import com.proc.claim.mapper.FeeCalculationMapper;
import com.proc.claim.model.dto.FeeCalculationDTO;
import com.proc.claim.exception.CustomException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.math.BigDecimal;

@Slf4j
@Service
@RequiredArgsConstructor
public class FeeCalculationService {
    
    private final FeeCalculationMapper feeCalculationMapper;

    @Transactional(readOnly = true)
    public FeeCalculationDTO getFeeCalculation(String claimId, String claimDetailId) {
        return feeCalculationMapper.selectFeeCalculation(claimId, claimDetailId);
    }

    @Transactional(readOnly = true)
    public List<FeeCalculationDTO> getClaimFeeCalculations(String claimId) {
        return feeCalculationMapper.selectClaimFeeCalculations(claimId);
    }

    @Transactional
    public void calculateFee(FeeCalculationDTO feeCalculationDTO) {
        try {
            // 수가 계산 로직
            BigDecimal finalAmount = feeCalculationDTO.getOriginalAmount()
                    .subtract(feeCalculationDTO.getAdjustedAmount());
            feeCalculationDTO.setFinalAmount(finalAmount);

            if (feeCalculationMapper.selectFeeCalculation(feeCalculationDTO.getClaimId(), 
                    feeCalculationDTO.getClaimDetailId()) == null) {
                feeCalculationMapper.insertFeeCalculation(feeCalculationDTO);
            } else {
                feeCalculationMapper.updateFeeCalculation(feeCalculationDTO);
            }
        } catch (Exception e) {
            log.error("Error calculating fee: {} - {}", 
                    feeCalculationDTO.getClaimId(), feeCalculationDTO.getClaimDetailId(), e);
            throw new CustomException("FEE_CALC_ERROR", "수가 계산 중 오류가 발생했습니다.");
        }
    }
}