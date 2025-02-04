package com.proc.claim.utils;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import java.time.LocalDateTime;
import java.util.Date;

public class BatchUtils {
    
    public static JobParameters createJobParameters() {
        return new JobParametersBuilder()
                .addString("jobInstanceId", String.valueOf(System.currentTimeMillis()))
                .addDate("startTime", new Date())
                .toJobParameters();
    }

    public static boolean isJobCompleted(JobExecution jobExecution) {
        return jobExecution != null && jobExecution.getStatus().isComplete();
    }

    public static boolean isJobFailed(JobExecution jobExecution) {
        return jobExecution != null && jobExecution.getStatus().isFailed();
    }

    public static String getJobStatus(JobExecution jobExecution) {
        return jobExecution != null ? jobExecution.getStatus().name() : "UNKNOWN";
    }

    public static String createStepName(String jobName, String stepName) {
        return String.format("%s_%s", jobName, stepName);
    }
}