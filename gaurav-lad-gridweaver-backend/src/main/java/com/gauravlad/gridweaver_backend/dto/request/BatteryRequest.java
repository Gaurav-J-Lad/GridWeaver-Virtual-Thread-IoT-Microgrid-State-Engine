package com.gauravlad.gridweaver_backend.dto.request;

public record BatteryRequest(
        Long gridNodeId,
        Double chargeLevel,
        Double capacity,
        Double temperature
) {
}