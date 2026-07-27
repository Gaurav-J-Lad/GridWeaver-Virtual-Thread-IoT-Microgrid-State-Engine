package com.gauravlad.gridweaver_backend.dto.request;

import com.gauravlad.gridweaver_backend.enums.NodeType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record GridNodeRequest(

        @NotBlank(message = "Node ID is required")
        String nodeId,

        @NotNull(message = "Node Type is required")
        NodeType nodeType,

        @NotNull(message = "Latitude is required")
        Double latitude,

        @NotNull(message = "Longitude is required")
        Double longitude,

        @NotNull(message = "Current Power is required")
        Double currentPower
) {
}