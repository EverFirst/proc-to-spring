package com.proc.claim.exception;

import lombok.Getter;

@Getter
public class BatchException extends CustomException {
    
    private final String jobName;
    private final String stepName;

    public BatchException(String errorCode, String errorMessage, String jobName, String stepName) {
        super(errorCode, errorMessage);
        this.jobName = jobName;
        this.stepName = stepName;
    }

    public BatchException(String errorCode, String errorMessage, String jobName, String stepName, Throwable cause) {
        super(errorCode, errorMessage, cause);
        this.jobName = jobName;
        this.stepName = stepName;
    }
}