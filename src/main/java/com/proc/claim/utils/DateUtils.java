package com.proc.claim.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    
    private static final String DEFAULT_DATE_FORMAT = "yyyyMMdd";
    private static final String DEFAULT_DATETIME_FORMAT = "yyyyMMddHHmmss";
    
    public static String formatDate(LocalDateTime date) {
        return formatDate(date, DEFAULT_DATE_FORMAT);
    }
    
    public static String formatDateTime(LocalDateTime dateTime) {
        return formatDate(dateTime, DEFAULT_DATETIME_FORMAT);
    }
    
    public static String formatDate(LocalDateTime date, String pattern) {
        if (date == null) return null;
        return date.format(DateTimeFormatter.ofPattern(pattern));
    }
    
    public static LocalDateTime parseDate(String dateStr) {
        return parseDate(dateStr, DEFAULT_DATE_FORMAT);
    }
    
    public static LocalDateTime parseDateTime(String dateTimeStr) {
        return parseDate(dateTimeStr, DEFAULT_DATETIME_FORMAT);
    }
    
    public static LocalDateTime parseDate(String dateStr, String pattern) {
        if (dateStr == null || dateStr.trim().isEmpty()) return null;
        return LocalDateTime.parse(dateStr, DateTimeFormatter.ofPattern(pattern));
    }

    public static boolean isValidDate(String dateStr) {
        try {
            parseDate(dateStr);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isValidDateTime(String dateTimeStr) {
        try {
            parseDateTime(dateTimeStr);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}