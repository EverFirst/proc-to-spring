package com.proc.claim.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QualificationDTO {
    private String qualificationId;   // 자격ID
    private String patientId;         // 환자ID
    private String insuranceType;     // 보험종류
    private LocalDateTime startDate;  // 자격시작일
    private LocalDateTime endDate;    // 자격종료일
    private String statusCode;        // 상태코드
    private List<QualificationDetailDTO> details; // 자격 상세 정보

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class QualificationDetailDTO {
        private String detailCode;        // 상세코드
        private String detailValue;       // 상세값
        private String description;       // 설명
        private LocalDateTime validFrom;  // 유효시작일
        private LocalDateTime validTo;    // 유효종료일
    }
}