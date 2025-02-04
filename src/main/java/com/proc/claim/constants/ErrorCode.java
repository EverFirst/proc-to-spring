package com.proc.claim.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class ErrorCode {
    
    @Getter
    @RequiredArgsConstructor
    public enum Common {
        SYSTEM_ERROR("COM001", "시스템 오류가 발생했습니다."),
        INVALID_PARAMETER("COM002", "잘못된 파라미터입니다."),
        DATA_NOT_FOUND("COM003", "데이터를 찾을 수 없습니다.");

        private final String code;
        private final String message;
    }

    @Getter
    @RequiredArgsConstructor
    public enum Batch {
        JOB_FAILED("BAT001", "배치 작업이 실패했습니다."),
        STEP_FAILED("BAT002", "배치 스텝이 실패했습니다."),
        ALREADY_RUNNING("BAT003", "이미 실행 중인 배치가 있습니다.");

        private final String code;
        private final String message;
    }

    @Getter
    @RequiredArgsConstructor
    public enum Claim {
        INVALID_CLAIM("CLM001", "유효하지 않은 청구입니다."),
        QUALIFICATION_ERROR("CLM002", "자격 검증 오류"),
        CALCULATION_ERROR("CLM003", "수가 계산 오류");

        private final String code;
        private final String message;
    }
}