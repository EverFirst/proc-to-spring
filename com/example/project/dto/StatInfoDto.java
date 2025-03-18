package com.example.project.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

@Getter
@Builder
@ToString
@EqualsAndHashCode
public class StatInfoDto {
    /** 통계ID */
    @NotNull
    @Size(max = 10)
    private final String statId;

    /** 통계명 */
    @NotNull
    @Size(max = 50)
    private final String statNm;

    /** 통계유형 */
    @NotNull
    @Size(max = 1)
    private final String statTp;

    /** 통계항목 */
    @NotNull
    @Size(max = 30)
    private final String statItem;

    /** 대상일자 */
    @NotNull
    @Size(max = 8)
    private final String targetDt;

    /** 통계값 */
    @NotNull
    @Size(max = 50)
    private final String statVal;

    /** 수치값 */
    @NotNull
    private final Double numVal;

    /** 카테고리코드 */
    @NotNull
    @Size(max = 10)
    private final String cateCd;

    /** 카테고리명 */
    @NotNull
    @Size(max = 50)
    private final String cateNm;

    /** 메모 */
    @Size(max = 100)
    private final String memo;

    /** 등록일시 */
    @NotNull
    @Size(max = 14)
    private final String regDt;
}