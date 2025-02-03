package com.proc.claim.model.entity;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommonCode {
    
    private String code;            // 코드
    private String groupCode;       // 그룹 코드
    private String codeName;        // 코드명
    private String description;     // 설명
    private String useYn;          // 사용여부
    private String createdBy;       // 생성자
    private LocalDateTime createdAt;// 생성일시
    private String updatedBy;       // 수정자
    private LocalDateTime updatedAt;// 수정일시
}