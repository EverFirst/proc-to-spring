package com.proc.claim.model.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QualificationMaster {
    private String qualificationId;   // 자격ID
    private String patientId;         // 환자ID
    private String insuranceType;     // 보험종류
    private LocalDateTime startDate;  // 자격시작일
    private LocalDateTime endDate;    // 자격종료일
    private String statusCode;        // 상태코드
    private String createdBy;         // 생성자
    private LocalDateTime createdAt;  // 생성일시
    private String updatedBy;         // 수정자
    private LocalDateTime updatedAt;  // 수정일시
}