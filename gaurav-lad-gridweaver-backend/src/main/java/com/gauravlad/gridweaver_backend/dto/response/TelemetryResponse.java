package com.gauravlad.gridweaver_backend.dto.response;

import java.time.LocalDateTime;

public record TelemetryResponse(
        Long id,
        Double powerOutput,
        Double voltage,
        Double current,
        Double temperature,
        LocalDateTime timestamp
) {
}