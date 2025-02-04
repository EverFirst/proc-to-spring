package com.proc.claim.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClaimDTO {
    private String claimId;           // 청구ID
    private String patientId;         // 환자ID
    private String hospitalId;        // 병원ID
    private LocalDateTime claimDate;  // 청구일자
    private BigDecimal totalAmount;   // 총 청구금액
    private String statusCode;        // 상태코드
    private String processingYn;      // 처리여부
    private List<ClaimDetailDTO> details; // 청구 상세 목록

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class ClaimDetailDTO {
        private String claimDetailId;     // 청구상세ID
        private String treatmentCode;     // 진료코드
        private LocalDateTime treatmentDate; // 진료일자
        private Integer quantity;         // 수량
        private BigDecimal unitPrice;     // 단가
        private BigDecimal amount;        // 금액
        private String statusCode;        // 상태코드
    }
}