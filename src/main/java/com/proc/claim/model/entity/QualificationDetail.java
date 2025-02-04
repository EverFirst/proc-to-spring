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
public class QualificationDetail {
    private String qualificationId;   // 자격ID
    private String detailCode;        // 상세코드
    private String detailValue;       // 상세값
    private String description;       // 설명
    private LocalDateTime validFrom;  // 유효시작일
    private LocalDateTime validTo;    // 유효종료일
    private String statusCode;        // 상태코드
    private String createdBy;         // 생성자
    private LocalDateTime createdAt;  // 생성일시
    private String updatedBy;         // 수정자
    private LocalDateTime updatedAt;  // 수정일시
}