package com.gauravlad.gridweaver_backend.dto.request;

import jakarta.validation.constraints.NotNull;

public record BatteryRequest(
        @NotNull
        Long gridNodeId,

        @NotNull
        Double chargeLevel,

        @NotNull
        Double capacity,

        @NotNull
        Double temperature
) {
}