package com.proc.claim.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class StatusCode {
    
    @Getter
    @RequiredArgsConstructor
    public enum ClaimStatus {
        UNPROCESSED("01", "미처리"),
        IN_PROGRESS("02", "처리중"),
        COMPLETED("03", "처리완료"),
        ERROR("09", "오류");

        private final String code;
        private final String description;
    }

    @Getter
    @RequiredArgsConstructor
    public enum ValidationStatus {
        SUCCESS("01", "검증성공"),
        FAIL("02", "검증실패"),
        PENDING("03", "검증보류");

        private final String code;
        private final String description;
    }

    @Getter
    @RequiredArgsConstructor
    public enum ProcessStatus {
        SUCCESS("S", "성공"),
        FAIL("F", "실패"),
        PROCESSING("P", "처리중");

        private final String code;
        private final String description;
    }
}