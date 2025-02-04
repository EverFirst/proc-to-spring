package com.proc.claim.mapper;

import com.proc.claim.model.entity.ClaimMaster;
import com.proc.claim.model.entity.ClaimDetail;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ClaimMapper {
    
    // 청구 마스터 조회
    ClaimMaster selectClaimMaster(String claimId);
    
    // 미처리 청구 목록 조회
    List<ClaimMaster> selectUnprocessedClaims(int limit);
    
    // 청구 상세 목록 조회
    List<ClaimDetail> selectClaimDetails(String claimId);
    
    // 청구 마스터 등록
    int insertClaimMaster(ClaimMaster claimMaster);
    
    // 청구 상세 등록
    int insertClaimDetail(ClaimDetail claimDetail);
    
    // 청구 마스터 수정
    int updateClaimMaster(ClaimMaster claimMaster);
    
    // 청구 상세 수정
    int updateClaimDetail(ClaimDetail claimDetail);
    
    // 청구 상태 업데이트
    int updateClaimStatus(String claimId, String statusCode);
}