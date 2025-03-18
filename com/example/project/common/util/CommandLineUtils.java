package com.example.project.common.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 명령행 인자 파싱 및 검증을 위한 유틸리티 클래스
 * Command-line argument parsing and validation utility class
 */
public final class CommandLineUtils {

    /**
     * 생성자를 private으로 선언하여 인스턴스화 방지
     * Private constructor to prevent instantiation
     */
    private CommandLineUtils() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    /**
     * 명령행 인자를 파싱하여 애플리케이션 설정으로 변환
     * Parses command-line arguments into application configuration
     * 
     * @param args 명령행 인자 배열 / Command-line arguments array
     * @return ApplicationConfig 파싱된 설정 객체 / Parsed configuration object
     * @throws IllegalArgumentException 필수 파라미터 누락 시 / If required parameters are missing
     */
    public static ApplicationConfig parseArgs(String[] args) {
        ApplicationConfig config = new ApplicationConfig();

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-h":
                    if (i + 1 < args.length) {
                        config.setHospitalCode(args[++i]);
                    }
                    break;
                case "-u":
                    if (i + 1 < args.length) {
                        config.setUserId(args[++i]);
                    }
                    break;
                case "-d":
                    if (i + 1 < args.length) {
                        config.setWorkDate(args[++i]);
                    }
                    break;
                case "-j":
                    if (i + 1 < args.length) {
                        config.addJobId(args[++i]);
                    }
                    break;
                case "-p":
                    if (i + 1 < args.length) {
                        config.setJobParam(args[++i]);
                    }
                    break;
                case "-debug":
                    if (i + 1 < args.length) {
                        config.setDebugLevel(Integer.parseInt(args[++i]));
                    }
                    break;
                default:
                    config.setBuffer(args[i]);
            }
        }

        validateConfig(config);
        debugLogConfiguration(config);

        return config;
    }

    /**
     * 애플리케이션 설정의 유효성을 검증
     * Validates the application configuration
     * 
     * @param config 검증할 설정 객체 / Configuration to validate
     * @throws IllegalArgumentException 유효성 검증 실패 시 / If validation fails
     */
    private static void validateConfig(ApplicationConfig config) {
        if (config.getHospitalCode() == null || config.getHospitalCode().isEmpty()) {
            throw new IllegalArgumentException("Hospital code is required (-h)");
        }

        if (config.getUserId() == null || config.getUserId().isEmpty()) {
            throw new IllegalArgumentException("User ID is required (-u)");
        }

        if ((config.getBuffer() == null || config.getBuffer().isEmpty()) && 
            (config.getJobIds() == null || config.getJobIds().isEmpty())) {
            throw new IllegalArgumentException("Data or Job ID is required");
        }
    }

    /**
     * 설정 정보를 디버그 로그로 출력
     * Logs debug information about the configuration
     * 
     * @param config 로깅할 설정 객체 / Configuration to log
     */
    private static void debugLogConfiguration(ApplicationConfig config) {
        String logMessage = String.format(
            "Hospital Code[%s] User ID[%s] Work Date[%s] Debug Level[%d]",
            config.getHospitalCode(), 
            config.getUserId(), 
            config.getWorkDate(), 
            config.getDebugLevel()
        );
        System.out.println("[DEBUG] " + logMessage);
    }

    /**
     * 명령행 인자로부터 파싱된 애플리케이션 설정을 저장하는 내부 클래스
     * Inner class to hold parsed command-line arguments
     */
    public static class ApplicationConfig {
        private String hospitalCode = "";
        private String userId = "";
        private String workDate = "";
        private String jobParam = "";
        private String buffer = "";
        private int debugLevel = 0;
        private List<String> jobIds = new ArrayList<>();

        public String getHospitalCode() { return hospitalCode; }
        public void setHospitalCode(String hospitalCode) { this.hospitalCode = hospitalCode; }

        public String getUserId() { return userId; }
        public void setUserId(String userId) { this.userId = userId; }

        public String getWorkDate() { return workDate; }
        public void setWorkDate(String workDate) { this.workDate = workDate; }

        public String getJobParam() { return jobParam; }
        public void setJobParam(String jobParam) { this.jobParam = jobParam; }

        public String getBuffer() { return buffer; }
        public void setBuffer(String buffer) { this.buffer = buffer; }

        public int getDebugLevel() { return debugLevel; }
        public void setDebugLevel(int debugLevel) { this.debugLevel = debugLevel; }

        public List<String> getJobIds() { return jobIds; }
        public void addJobId(String jobId) { this.jobIds.add(jobId); }
    }
}
