package com.proc.claim.exception;

import org.springframework.batch.core.JobInterruptedException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(CustomException e) {
        log.error("CustomException: {}", e.getMessage(), e);
        ErrorResponse response = new ErrorResponse(e.getErrorCode(), e.getErrorMessage());
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(BatchException.class)
    public ResponseEntity<ErrorResponse> handleBatchException(BatchException e) {
        log.error("BatchException: Job={}, Step={}, Message={}", 
                  e.getJobName(), e.getStepName(), e.getMessage(), e);
        ErrorResponse response = new ErrorResponse(e.getErrorCode(), e.getErrorMessage());
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler({
        JobExecutionAlreadyRunningException.class,
        JobRestartException.class,
        JobInstanceAlreadyCompleteException.class,
        JobInterruptedException.class
    })
    public ResponseEntity<ErrorResponse> handleJobException(Exception e) {
        log.error("JobException: {}", e.getMessage(), e);
        ErrorResponse response = new ErrorResponse("BATCH_ERROR", e.getMessage());
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        log.error("Unexpected error occurred: {}", e.getMessage(), e);
        ErrorResponse response = new ErrorResponse("SYSTEM_ERROR", "시스템 오류가 발생했습니다.");
        return ResponseEntity.internalServerError().body(response);
    }
}