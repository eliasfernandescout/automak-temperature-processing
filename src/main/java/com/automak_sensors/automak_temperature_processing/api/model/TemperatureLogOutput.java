package com.automak_sensors.automak_temperature_processing.api.model;

import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@Builder
public class TemperatureLogOutput {
    private String id;
    private String sensorId;
    private OffsetDateTime registeredAt;
    private Double value;
}
