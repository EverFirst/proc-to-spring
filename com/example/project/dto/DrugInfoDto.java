package com.example.project.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Getter
@Builder
@ToString
@EqualsAndHashCode
public class DrugInfoDto {
    /** 약품코드 */
    @NotNull
    @Size(max = 10)
    private final String drugCd;

    /** 약품명 */
    @NotNull
    @Size(max = 100)
    private final String drugNm;

    /** 약품유형 */
    @NotNull
    @Size(max = 1)
    private final String drugTp;

    /** 제약회사코드 */
    @NotNull
    @Size(max = 10)
    private final String comCd;

    /** 제약회사명 */
    @NotNull
    @Size(max = 50)
    private final String comNm;

    /** 성분 */
    @NotNull
    @Size(max = 200)
    private final String ingredient;

    /** 표준코드 */
    @NotNull
    @Size(max = 10)
    private final String stdCd;

    /** ATC코드 */
    @NotNull
    @Size(max = 7)
    private final String atcCd;

    /** 단위용량 */
    @NotNull
    @Positive
    private final Double unitDose;

    /** 용량단위 */
    @NotNull
    @Size(max = 10)
    private final String doseUnit;

    /** 투여경로 */
    @NotNull
    @Size(max = 30)
    private final String adminRoute;

    /** 제형코드 */
    @NotNull
    @Size(max = 2)
    private final String formCd;

    /** 제형명 */
    @NotNull
    @Size(max = 30)
    private final String formNm;

    /** 조제단위 */
    @NotNull
    private final Integer dispUnit;

    /** 조제단위명 */
    @NotNull
    @Size(max = 20)
    private final String dispUnitNm;

    /** 마약여부 */
    @NotNull
    @Size(max = 1)
    private final String narcoticYn;

    /** 취소여부 */
    @NotNull
    @Size(max = 1)
    private final String cancelYn;

    /** 보험유형 */
    @NotNull
    @Size(max = 2)
    private final String insTp;

    /** 단가 */
    @NotNull
    @Positive
    private final Double unitPrice;

    /** 등록일시 */
    @NotNull
    @Size(max = 14)
    private final String regDt;

    /** 수정일시 */
    @NotNull
    @Size(max = 14)
    private final String modDt;
}