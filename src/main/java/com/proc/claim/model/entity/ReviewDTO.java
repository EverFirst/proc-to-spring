package com.proc.claim.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import java.time.LocalDateTime;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewDTO {
    private String claimId;           // 청구ID
    private String claimDetailId;     // 청구상세ID
    private String reviewCode;        // 심사코드
    private String reviewResult;      // 심사결과
    private String reviewMessage;     // 심사메시지
    private BigDecimal adjustAmount;  // 조정금액
    private String reviewerId;        // 심사자ID
    private LocalDateTime reviewDate; // 심사일자
}