package com.proc.claim.batch.step;

import com.proc.claim.model.entity.ClaimMaster;
import com.proc.claim.model.dto.FeeCalculationDTO;
import com.proc.claim.service.ClaimService;
import com.proc.claim.service.FeeCalculationService;
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
public class FeeCalculationStep {

    private final StepBuilderFactory stepBuilderFactory;
    private final ClaimService claimService;
    private final FeeCalculationService feeCalculationService;
    private final PlatformTransactionManager transactionManager;
    private static final int CHUNK_SIZE = 1000;

    public Step executeStep() {
        return stepBuilderFactory.get("feeCalculationStep")
                .<ClaimMaster, FeeCalculationDTO>chunk(CHUNK_SIZE)
                .reader(claimReader())
                .processor(feeCalculationProcessor())
                .writer(feeCalculationWriter())
                .transactionManager(transactionManager)
                .build();
    }

    private ItemReader<ClaimMaster> claimReader() {
        return null; // 이전 스텝의 결과를 읽어오는 리더 구현
    }

    private ItemProcessor<ClaimMaster, FeeCalculationDTO> feeCalculationProcessor() {
        return claim -> {
            FeeCalculationDTO feeCalculationDTO = new FeeCalculationDTO();
            feeCalculationDTO.setClaimId(claim.getClaimId());
            // 수가 계산 로직 구현
            return feeCalculationDTO;
        };
    }

    private ItemWriter<FeeCalculationDTO> feeCalculationWriter() {
        return fees -> {
            for (FeeCalculationDTO fee : fees) {
                feeCalculationService.calculateFee(fee);
            }
        };
    }
}