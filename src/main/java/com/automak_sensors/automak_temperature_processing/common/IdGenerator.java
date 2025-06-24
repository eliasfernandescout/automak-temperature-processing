package com.automak_sensors.automak_temperature_processing.common;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class IdGenerator {
    public static String generateId() {
        LocalDateTime now = LocalDateTime.now();
        String idStr = now.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"))
                + String.format("%09d", now.getNano())
                + String.format("%04d", (int)(Math.random() * 10000));
        return idStr;
    }
}