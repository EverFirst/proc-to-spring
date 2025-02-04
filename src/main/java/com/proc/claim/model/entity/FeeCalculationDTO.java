package com.proc.claim.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FeeCalculationDTO {
    private String claimId;           // 청구ID
    private String claimDetailId;     // 청구상세ID
    private String treatmentCode;     // 진료코드
    private BigDecimal originalAmount; // 원청구금액
    private BigDecimal adjustedAmount; // 조정금액
    private BigDecimal finalAmount;    // 최종금액
    private String adjustReason;       // 조정사유
}