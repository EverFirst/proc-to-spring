package com.proc.claim.batch.step;

import com.proc.claim.model.entity.ClaimMaster;
import com.proc.claim.service.ClaimService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.List;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class UnprocessedClaimLoadStep {

    private final StepBuilderFactory stepBuilderFactory;
    private final ClaimService claimService;
    private final PlatformTransactionManager transactionManager;
    private static final int CHUNK_SIZE = 1000;

    public Step executeStep() {
        return stepBuilderFactory.get("unprocessedClaimLoadStep")
                .<ClaimMaster, ClaimMaster>chunk(CHUNK_SIZE)
                .reader(unprocessedClaimReader())
                .processor(unprocessedClaimProcessor())
                .writer(unprocessedClaimWriter())
                .transactionManager(transactionManager)
                .build();
    }

    private ItemReader<ClaimMaster> unprocessedClaimReader() {
        List<ClaimMaster> unprocessedClaims = claimService.getUnprocessedClaims(CHUNK_SIZE);
        return new ListItemReader<>(unprocessedClaims);
    }

    private ItemProcessor<ClaimMaster, ClaimMaster> unprocessedClaimProcessor() {
        return claim -> {
            log.info("Processing claim: {}", claim.getClaimId());
            claim.setStatusCode("02"); // 처리중 상태로 변경
            return claim;
        };
    }

    private ItemWriter<ClaimMaster> unprocessedClaimWriter() {
        return claims -> {
            for (ClaimMaster claim : claims) {
                claimService.updateClaimStatus(claim.getClaimId(), claim.getStatusCode());
                log.info("Updated claim status: {}", claim.getClaimId());
            }
        };
    }
}