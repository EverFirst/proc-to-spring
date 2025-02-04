package com.proc.claim.model.entity;

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
public class ClaimDetail {
    private String claimId;           // 청구ID
    private String claimDetailId;     // 청구상세ID
    private String treatmentCode;     // 진료코드
    private LocalDateTime treatmentDate; // 진료일자
    private Integer quantity;         // 수량
    private BigDecimal unitPrice;     // 단가
    private BigDecimal amount;        // 금액
    private String statusCode;        // 상태코드
    private String errorCode;         // 오류코드
    private String errorMessage;      // 오류메시지
    private String createdBy;         // 생성자
    private LocalDateTime createdAt;  // 생성일시
    private String updatedBy;         // 수정자
    private LocalDateTime updatedAt;  // 수정일시
}