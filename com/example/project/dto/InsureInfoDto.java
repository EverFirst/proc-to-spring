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
public class InsureInfoDto {
    /** 보험유형 */
    @Size(max = 2)
    @NotNull
    private final String insTp;

    /** 보험명 */
    @Size(max = 50)
    @NotNull
    private final String insNm;

    /** 항목유형 */
    @Size(max = 2)
    @NotNull
    private final String itemTp;

    /** 보험적용비율 */
    @Size(max = 3)
    @NotNull
    private final String insRatio;

    /** 적용시작일 */
    @Size(max = 8)
    @NotNull
    private final String appStrtDt;

    /** 적용종료일 */
    @Size(max = 8)
    @NotNull
    private final String appEndDt;

    /** 최대금액 */
    @Positive
    private final Double maxAmt;

    /** 메모 */
    @Size(max = 100)
    private final String memo;

    /** 사용여부 */
    @Size(max = 1)
    @NotNull
    private final String useYn;

    /** 등록일시 */
    @Size(max = 14)
    @NotNull
    private final String regDt;

    /** 수정일시 */
    @Size(max = 14)
    @NotNull
    private final String modDt;
}