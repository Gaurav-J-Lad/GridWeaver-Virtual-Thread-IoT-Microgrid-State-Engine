package com.gauravlad.gridweaver_backend.dto.response;

import com.gauravlad.gridweaver_backend.enums.EventType;

import java.time.LocalDateTime;

public record EventLogResponse(
        Long id,
        EventType eventType,
        String description,
        LocalDateTime createdAt
) {
}
