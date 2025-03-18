package com.example.project.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;

@Getter
@Builder
@ToString
public class PrscItemDto {
    /** 순번 */
    @NotNull
    @Min(0)
    private Integer seqNo;

    /** 처방항목코드 */
    @NotNull
    @Size(max = 10)
    private String itemCd;

    /** 처방항목명 */
    @NotNull
    @Size(max = 50)
    private String itemNm;

    /** 항목유형 */
    @Size(max = 2)
    private String itemTp;

    /** 수량 */
    @NotNull
    @Min(0)
    private Integer itemQty;

    /** 투약일수 */
    @NotNull
    @Min(0)
    private Integer itemDays;

    /** 단가 */
    @NotNull
    private Double unitPrice;

    /** 금액 */
    @NotNull
    private Double itemAmt;

    /** 보험구분 */
    @Size(max = 2)
    private String insDiv;

    /** 보험적용비율 */
    @Size(max = 3)
    private String insRatio;

    /** 투약주기코드 */
    @Size(max = 2)
    private String freqCd;

    /** 투약주기명 */
    @Size(max = 30)
    private String freqNm;

    /** 용법코드 */
    @Size(max = 2)
    private String usageCd;

    /** 용법명 */
    @Size(max = 100)
    private String usageNm;

    /** 비고 */
    @Size(max = 100)
    private String remark;

    /** 사용여부 */
    @Size(max = 1)
    private String useYn;
}