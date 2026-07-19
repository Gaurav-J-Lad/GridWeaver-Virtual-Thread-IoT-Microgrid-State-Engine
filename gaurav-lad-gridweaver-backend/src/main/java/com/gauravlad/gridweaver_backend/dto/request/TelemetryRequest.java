package com.gauravlad.gridweaver_backend.dto.request;
public record TelemetryRequest(
        Long gridNodeId,
        Double powerOutput,
        Double voltage,
        Double current,
        Double temperature
) {
}