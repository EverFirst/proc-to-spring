package com.proc.claim.batch.job;

import com.proc.claim.batch.step.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class ClaimProcessingJob {

    private final JobBuilderFactory jobBuilderFactory;
    private final UnprocessedClaimLoadStep unprocessedClaimLoadStep;
    private final QualificationValidationStep qualificationValidationStep;
    private final ReviewCriteriaStep reviewCriteriaStep;
    private final FeeCalculationStep feeCalculationStep;

    @Bean
    public Job processClaimJob() {
        return jobBuilderFactory.get("processClaimJob")
                .incrementer(new RunIdIncrementer())
                .start(unprocessedClaimLoadStep.executeStep())
                .next(qualificationValidationStep.executeStep())
                .next(reviewCriteriaStep.executeStep())
                .next(feeCalculationStep.executeStep())
                .build();
    }
}