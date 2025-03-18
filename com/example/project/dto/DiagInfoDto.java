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
public class DiagInfoDto {
    /** 진단번호 */
    @NotBlank
    @Size(max = 11)
    private final String diagNo;

    /** 환자ID */
    @NotBlank
    @Size(max = 13)
    private final String patId;

    /** 병원코드 */
    @NotBlank
    @Size(max = 11)
    private final String hospCd;

    /** 진료과코드 */
    @NotBlank
    @Size(max = 5)
    private final String deptCd;

    /** 의사코드 */
    @NotBlank
    @Size(max = 6)
    private final String drCd;

    /** 진단일자 */
    @NotBlank
    @Size(max = 9)
    private final String diagDt;

    /** 진단상태 */
    @NotBlank
    @Size(max = 2)
    private final String diagStat;

    /** 진단코드 */
    @NotBlank
    @Size(max = 10)
    private final String diagCd;

    /** 진단명 */
    @NotBlank
    @Size(max = 100)
    private final String diagNm;

    /** 주호소 */
    @Size(max = 500)
    private final String chiefComp;

    /** 현병력 */
    @Size(max = 1000)
    private final String presentIll;

    /** 과거력 */
    @Size(max = 1000)
    private final String pastHist;

    /** 가족력 */
    @Size(max = 500)
    private final String familyHist;

    /** 신체검사 */
    @Size(max = 1000)
    private final String physicalExam;

    /** 검사소견 */
    @Size(max = 1000)
    private final String labFindings;

    /** 치료내용 */
    @Size(max = 1000)
    private final String treatment;

    /** 메모 */
    @Size(max = 500)
    private final String memo;

    /** 보험유형 */
    @NotBlank
    @Size(max = 3)
    private final String insTp;

    /** 방문유형 */
    @NotBlank
    @Size(max = 2)
    private final String visitTp;

    /** 등록자ID */
    @NotBlank
    @Size(max = 9)
    private final String regId;

    /** 등록일시 */
    @NotBlank
    @Size(max = 15)
    private final String regDt;

    /** 수정자ID */
    @NotBlank
    @Size(max = 9)
    private final String modId;

    /** 수정일시 */
    @NotBlank
    @Size(max = 15)
    private final String modDt;
}