package com.example.project.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;

@Getter
@Builder
@ToString
public final class PatientInfoDto {
    /** 환자명 */
    @NotBlank(message = "Patient name is required")
    @Size(max = 50, message = "Patient name must be less than 50 characters")
    private final String patNm;

    /** 주민번호 */
    @NotBlank(message = "Resident registration number is required")
    @Size(max = 13, message = "Resident registration number must be less than 14 characters")
    private final String rrnNo;

    /** 성별(M/F) */
    @NotBlank(message = "Gender is required")
    @Size(max = 1, message = "Gender must be M or F")
    private final String sexTp;

    /** 생년월일 */
    @NotBlank(message = "Birth date is required")
    @Size(max = 8, message = "Birth date must be less than 9 characters")
    private final String birthDt;

    /** 나이 */
    @Min(value = 0, message = "Age must be 0 or greater")
    @Max(value = 200, message = "Age must be less than 200")
    private final Integer age;

    /** 전화번호 */
    @Size(max = 15, message = "Telephone number must be less than 16 characters")
    private final String telNo;

    /** 휴대전화 */
    @Size(max = 15, message = "Mobile number must be less than 16 characters")
    private final String mobNo;

    /** 이메일 */
    @Size(max = 100, message = "Email must be less than 101 characters")
    private final String email;

    /** 주소 */
    @Size(max = 200, message = "Address must be less than 201 characters")
    private final String addr;

    /** 보험유형 */
    @Size(max = 2, message = "Insurance type must be less than 3 characters")
    private final String insTp;

    /** 보험증번호 */
    @Size(max = 19, message = "Insurance number must be less than 20 characters")
    private final String insNo;

    /** 환자상태 */
    @Size(max = 1, message = "Patient status must be less than 2 characters")
    private final String patStat;

    /** 알러지정보 */
    @Size(max = 200, message = "Allergy information must be less than 201 characters")
    private final String allergy;

    /** 혈액형 */
    @Size(max = 2, message = "Blood type must be less than 3 characters")
    private final String bloodTp;

    /** 비고 */
    @Size(max = 500, message = "Remarks must be less than 501 characters")
    private final String remarks;

    /** 등록일시 */
    @NotBlank(message = "Registration date is required")
    @Size(max = 14, message = "Registration date must be less than 15 characters")
    private final String regDt;

    /** 수정일시 */
    @Size(max = 14, message = "Modification date must be less than 15 characters")
    private final String modDt;
}