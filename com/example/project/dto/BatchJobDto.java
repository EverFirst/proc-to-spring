package com.example.project.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;

@Getter
@Builder
@ToString
@EqualsAndHashCode
public class BatchJobDto {
    /** 작업ID */
    @NotNull
    @Size(max = 10)
    private final String jobId;

    /** 작업명 */
    @NotNull
    @Size(max = 50)
    private final String jobNm;

    /** 작업유형 */
    @NotNull
    @Size(max = 1)
    private final String jobTp;

    /** 작업상태 */
    @NotNull
    @Size(max = 1)
    private final String jobStat;

    /** 작업설명 */
    @Size(max = 200)
    private final String jobDesc;

    /** 실행주기 */
    @Size(max = 50)
    private final String execCycle;

    /** 다음실행일시 */
    @Size(max = 14)
    private final String nextDt;

    /** 마지막실행일시 */
    @Size(max = 14)
    private final String lastDt;

    /** 타임아웃(초) */
    @Min(0)
    private final Integer timeout;

    /** 파라미터 */
    @Size(max = 200)
    private final String param;

    /** 로그파일 */
    @Size(max = 100)
    private final String logFile;

    /** 사용여부 */
    @NotNull
    @Size(max = 1)
    private final String useYn;

    /** 우선순위 */
    @Min(0)
    private final Integer priority;

    /** 등록일시 */
    @Size(max = 14)
    private final String regDt;

    /** 수정일시 */
    @Size(max = 14)
    private final String modDt;
}