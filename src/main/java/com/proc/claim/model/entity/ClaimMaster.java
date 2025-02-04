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
public class ClaimMaster {
    private String claimId;           // 청구ID
    private String patientId;         // 환자ID
    private String hospitalId;        // 병원ID
    private LocalDateTime claimDate;  // 청구일자
    private BigDecimal totalAmount;   // 총 청구금액
    private String statusCode;        // 상태코드
    private String processingYn;      // 처리여부
    private LocalDateTime processedDate; // 처리일자
    private String errorCode;         // 오류코드
    private String errorMessage;      // 오류메시지
    private String createdBy;         // 생성자
    private LocalDateTime createdAt;  // 생성일시
    private String updatedBy;         // 수정자
    private LocalDateTime updatedAt;  // 수정일시
}