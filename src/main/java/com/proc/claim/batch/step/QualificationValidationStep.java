package com.proc.claim.batch.step;

import com.proc.claim.model.entity.ClaimMaster;
import com.proc.claim.service.ClaimService;
import com.proc.claim.service.QualificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class QualificationValidationStep {

    private final StepBuilderFactory stepBuilderFactory;
    private final ClaimService claimService;
    private final QualificationService qualificationService;
    private final PlatformTransactionManager transactionManager;
    private static final int CHUNK_SIZE = 1000;

    public Step executeStep() {
        return stepBuilderFactory.get("qualificationValidationStep")
                .<ClaimMaster, ClaimMaster>chunk(CHUNK_SIZE)
                .reader(claimReader())
                .processor(qualificationProcessor())
                .writer(resultWriter())
                .transactionManager(transactionManager)
                .build();
    }

    private ItemReader<ClaimMaster> claimReader() {
        return null; // 이전 스텝의 결과를 읽어오는 리더 구현
    }

    private ItemProcessor<ClaimMaster, ClaimMaster> qualificationProcessor() {
        return claim -> {
            try {
                qualificationService.validateQualification(claim.getPatientId());
                claim.setStatusCode("03"); // 자격검증 완료
            } catch (Exception e) {
                log.error("Qualification validation failed: {}", claim.getClaimId(), e);
                claim.setStatusCode("09"); // 오류
                claim.setErrorCode("QUAL_ERROR");
                claim.setErrorMessage(e.getMessage());
            }
            return claim;
        };
    }

    private ItemWriter<ClaimMaster> resultWriter() {
        return claims -> {
            for (ClaimMaster claim : claims) {
                claimService.updateClaimStatus(claim.getClaimId(), claim.getStatusCode());
            }
        };
    }
}