package com.proc.claim.mapper;

import com.proc.claim.model.entity.QualificationMaster;
import com.proc.claim.model.entity.QualificationDetail;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface QualificationMapper {
    
    // 자격 마스터 조회
    QualificationMaster selectQualificationMaster(String qualificationId);
    
    // 환자 자격 조회
    QualificationMaster selectPatientQualification(String patientId);
    
    // 자격 상세 목록 조회
    List<QualificationDetail> selectQualificationDetails(String qualificationId);
    
    // 자격 마스터 등록
    int insertQualificationMaster(QualificationMaster qualificationMaster);
    
    // 자격 상세 등록
    int insertQualificationDetail(QualificationDetail qualificationDetail);
    
    // 자격 상태 업데이트
    int updateQualificationStatus(String qualificationId, String statusCode);
}