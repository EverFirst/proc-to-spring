package com.proc.claim.batch.step;

import com.proc.claim.model.entity.ClaimMaster;
import com.proc.claim.model.dto.ReviewDTO;
import com.proc.claim.service.ClaimService;
import com.proc.claim.service.ReviewService;
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
public class ReviewCriteriaStep {

    private final StepBuilderFactory stepBuilderFactory;
    private final ClaimService claimService;
    private final ReviewService reviewService;
    private final PlatformTransactionManager transactionManager;
    private static final int CHUNK_SIZE = 1000;

    public Step executeStep() {
        return stepBuilderFactory.get("reviewCriteriaStep")
                .<ClaimMaster, ReviewDTO>chunk(CHUNK_SIZE)
                .reader(claimReader())
                .processor(reviewProcessor())
                .writer(reviewWriter())
                .transactionManager(transactionManager)
                .build();
    }

    private ItemReader<ClaimMaster> claimReader() {
        return null; // 이전 스텝의 결과를 읽어오는 리더 구현
    }

    private ItemProcessor<ClaimMaster, ReviewDTO> reviewProcessor() {
        return claim -> {
            ReviewDTO reviewDTO = new ReviewDTO();
            reviewDTO.setClaimId(claim.getClaimId());
            // 심사 기준 적용 로직 구현
            return reviewDTO;
        };
    }

    private ItemWriter<ReviewDTO> reviewWriter() {
        return reviews -> {
            for (ReviewDTO review : reviews) {
                reviewService.processReview(review);
            }
        };
    }
}