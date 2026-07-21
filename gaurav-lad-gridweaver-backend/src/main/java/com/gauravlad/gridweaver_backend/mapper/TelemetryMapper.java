package com.gauravlad.gridweaver_backend.mapper;

import com.gauravlad.gridweaver_backend.dto.request.TelemetryRequest;
import com.gauravlad.gridweaver_backend.dto.response.TelemetryResponse;
import com.gauravlad.gridweaver_backend.entity.GridNode;
import com.gauravlad.gridweaver_backend.entity.Telemetry;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TelemetryMapper {

    public Telemetry toEntity(TelemetryRequest request, GridNode gridNode) {

        return Telemetry.builder()
                .gridNode(gridNode)
                .powerOutput(request.powerOutput())
                .voltage(request.voltage())
                .current(request.current())
                .temperature(request.temperature())
                .timestamp(LocalDateTime.now())
                .build();
    }

    public TelemetryResponse toResponse(Telemetry telemetry) {

        return new TelemetryResponse(
                telemetry.getId(),
                telemetry.getPowerOutput(),
                telemetry.getVoltage(),
                telemetry.getCurrent(),
                telemetry.getTemperature(),
                telemetry.getTimestamp()
        );
    }
}