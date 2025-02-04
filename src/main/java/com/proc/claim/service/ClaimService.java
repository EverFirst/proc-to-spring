package com.proc.claim.service;

import com.proc.claim.mapper.ClaimMapper;
import com.proc.claim.model.entity.ClaimMaster;
import com.proc.claim.model.entity.ClaimDetail;
import com.proc.claim.model.dto.ClaimDTO;
import com.proc.claim.exception.CustomException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClaimService {
    
    private final ClaimMapper claimMapper;

    @Transactional(readOnly = true)
    public ClaimMaster getClaim(String claimId) {
        return claimMapper.selectClaimMaster(claimId);
    }

    @Transactional(readOnly = true)
    public List<ClaimMaster> getUnprocessedClaims(int limit) {
        return claimMapper.selectUnprocessedClaims(limit);
    }

    @Transactional
    public void processClaim(String claimId) {
        ClaimMaster claim = claimMapper.selectClaimMaster(claimId);
        if (claim == null) {
            throw new CustomException("CLAIM_NOT_FOUND", "청구 정보를 찾을 수 없습니다.");
        }

        try {
            claim.setProcessingYn("Y");
            claimMapper.updateClaimMaster(claim);
        } catch (Exception e) {
            log.error("Error processing claim: {}", claimId, e);
            throw new CustomException("CLAIM_PROCESS_ERROR", "청구 처리 중 오류가 발생했습니다.");
        }
    }

    @Transactional(readOnly = true)
    public List<ClaimDetail> getClaimDetails(String claimId) {
        return claimMapper.selectClaimDetails(claimId);
    }

    @Transactional
    public void updateClaimStatus(String claimId, String statusCode) {
        claimMapper.updateClaimStatus(claimId, statusCode);
    }
}