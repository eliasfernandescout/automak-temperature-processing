package com.automak_sensors.automak_temperature_processing.api.controller;

import com.automak_sensors.automak_temperature_processing.api.model.TemperatureLogOutput;
import com.automak_sensors.automak_temperature_processing.common.IdGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/sensors/{sensorId}/temperature/data")
@Slf4j
public class TemperatureController {

    @PostMapping(consumes = MediaType.TEXT_PLAIN_VALUE)
    public void data(@PathVariable String sensorId, @RequestBody String input) {
        if(input == null || input.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Double temperature;
        try {
            temperature = Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid temperature value");
        }
        TemperatureLogOutput logOutput = TemperatureLogOutput.builder()
                .id(IdGenerator.generateId())
                .sensorId(sensorId)
                .value(temperature)
                .registeredAt(java.time.OffsetDateTime.now())
                .build();

        log.info("Temperature received: {}", logOutput.toString());

    }
}
