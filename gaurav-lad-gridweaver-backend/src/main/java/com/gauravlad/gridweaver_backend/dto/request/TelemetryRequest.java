package com.gauravlad.gridweaver_backend.dto.request;

import jakarta.validation.constraints.NotNull;

public record TelemetryRequest(
        @NotNull(message = "Grid Node Id is required")
        Long gridNodeId,

        @NotNull(message = "Power Output is required")
        Double powerOutput,

        @NotNull(message = "Voltage is required")
        Double voltage,

        @NotNull(message = "Current is required")
        Double current,

        @NotNull(message = "Temperature is required")
        Double temperature
) {
}