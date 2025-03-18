package com.example.project.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotBlank;

@Getter
@Builder
@ToString
@EqualsAndHashCode
public class DrugInteractDto {
    /** 약품코드1 */
    @NotBlank
    @Size(max = 10)
    private final String drugCd1;

    /** 약품코드2 */
    @NotBlank
    @Size(max = 10)
    private final String drugCd2;

    /** 상호작용수준 */
    @NotBlank
    @Size(max = 1)
    private final String intLevel;

    /** 상호작용설명 */
    @NotBlank
    @Size(max = 500)
    private final String intDesc;

    /** 영향 */
    @NotBlank
    @Size(max = 200)
    private final String effect;

    /** 기전 */
    @NotBlank
    @Size(max = 200)
    private final String mechanism;

    /** 관리방법 */
    @NotBlank
    @Size(max = 200)
    private final String manageDesc;

    /** 참고정보 */
    @NotBlank
    @Size(max = 200)
    private final String refInfo;

    /** 등록일시 */
    @NotBlank
    @Size(max = 14)
    private final String regDt;
}