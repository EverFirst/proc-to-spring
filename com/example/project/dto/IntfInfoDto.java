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
public class IntfInfoDto {
    /** 인터페이스ID */
    @NotNull
    @Size(max = 10)
    private final String intfId;

    /** 인터페이스명 */
    @NotNull
    @Size(max = 50)
    private final String intfNm;

    /** 인터페이스유형 */
    @NotNull
    @Size(max = 1)
    private final String intfTp;

    /** 대상시스템 */
    @NotNull
    @Size(max = 30)
    private final String targetSys;

    /** 인터페이스URL */
    @NotNull
    @Size(max = 200)
    private final String intfUrl;

    /** 사용자이름 */
    @NotNull
    @Size(max = 30)
    private final String username;

    /** 비밀번호 */
    @NotNull
    @Size(max = 30)
    private final String password;

    /** 연결정보 */
    @NotNull
    @Size(max = 200)
    private final String connInfo;

    /** 타임아웃(초) */
    @NotNull
    @Min(0)
    private final Integer timeout;

    /** 파라미터 */
    @NotNull
    @Size(max = 200)
    private final String param;

    /** 사용여부 */
    @NotNull
    @Size(max = 1)
    private final String useYn;

    /** 등록일시 */
    @NotNull
    @Size(max = 14)
    private final String regDt;

    /** 수정일시 */
    @NotNull
    @Size(max = 14)
    private final String modDt;
}