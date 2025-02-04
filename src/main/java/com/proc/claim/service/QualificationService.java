package com.proc.claim.service;

import com.proc.claim.mapper.QualificationMapper;
import com.proc.claim.model.entity.QualificationMaster;
import com.proc.claim.model.entity.QualificationDetail;
import com.proc.claim.model.dto.QualificationDTO;
import com.proc.claim.exception.CustomException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class QualificationService {
    
    private final QualificationMapper qualificationMapper;

    @Transactional(readOnly = true)
    public QualificationMaster getQualification(String qualificationId) {
        return qualificationMapper.selectQualificationMaster(qualificationId);
    }

    @Transactional(readOnly = true)
    public QualificationMaster getPatientQualification(String patientId) {
        QualificationMaster qualification = qualificationMapper.selectPatientQualification(patientId);
        if (qualification == null) {
            throw new CustomException("QUAL_NOT_FOUND", "자격 정보를 찾을 수 없습니다.");
        }
        return qualification;
    }

    @Transactional(readOnly = true)
    public List<QualificationDetail> getQualificationDetails(String qualificationId) {
        return qualificationMapper.selectQualificationDetails(qualificationId);
    }

    @Transactional
    public void validateQualification(String patientId) {
        QualificationMaster qualification = getPatientQualification(patientId);
        if (!"01".equals(qualification.getStatusCode())) {
            throw new CustomException("INVALID_QUALIFICATION", "유효하지 않은 자격입니다.");
        }
    }
}