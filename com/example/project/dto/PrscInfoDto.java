package com.example.project.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Digits;

@Getter
@Builder
@ToString
@EqualsAndHashCode
public class PrscInfoDto {
    /** 처방전번호 */
    @NotNull
    @Size(max = 11)
    private final String prscNo;

    /** 환자ID */
    @NotNull
    @Size(max = 13)
    private final String patId;

    /** 진단번호 */
    @NotNull
    @Size(max = 11)
    private final String diagNo;

    /** 병원코드 */
    @NotNull
    @Size(max = 11)
    private final String hospCd;

    /** 진료과코드 */
    @NotNull
    @Size(max = 5)
    private final String deptCd;

    /** 의사코드 */
    @NotNull
    @Size(max = 6)
    private final String drCd;

    /** 처방일자 */
    @NotNull
    @Size(max = 9)
    private final String prscDt;

    /** 처방상태 */
    @NotNull
    @Size(max = 2)
    private final String prscStat;

    /** 보험유형 */
    @NotNull
    @Size(max = 3)
    private final String insTp;

    /** 메모 */
    @NotNull
    @Size(max = 200)
    private final String memo;

    /** 총금액 */
    @NotNull
    private final Double totAmt;

    /** 보험금액 */
    @NotNull
    private final Double insAmt;

    /** 환자부담금 */
    @NotNull
    private final Double patAmt;

    /** 출력유형 */
    @NotNull
    @Size(max = 2)
    private final String prtTp;

    /** 출력일시 */
    @NotNull
    @Size(max = 15)
    private final String prtDt;

    /** 결제방식 */
    @NotNull
    @Size(max = 3)
    private final String payTp;

    /** 결제상태 */
    @NotNull
    @Size(max = 2)
    private final String payStat;

    /** 결제일시 */
    @NotNull
    @Size(max = 15)
    private final String payDt;

    /** 청구여부 */
    @NotNull
    @Size(max = 2)
    private final String claimYn;

    /** 청구일시 */
    @NotNull
    @Size(max = 15)
    private final String claimDt;

    /** 청구상태 */
    @NotNull
    @Size(max = 2)
    private final String claimStat;

    /** 등록자ID */
    @NotNull
    @Size(max = 9)
    private final String regId;

    /** 등록일시 */
    @NotNull
    @Size(max = 15)
    private final String regDt;

    /** 수정자ID */
    @NotNull
    @Size(max = 9)
    private final String modId;

    /** 수정일시 */
    @NotNull
    @Size(max = 15)
    private final String modDt;
}