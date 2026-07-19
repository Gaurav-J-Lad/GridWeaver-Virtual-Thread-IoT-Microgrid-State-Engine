package com.gauravlad.gridweaver_backend.dto.request;

import com.gauravlad.gridweaver_backend.enums.NodeType;

public record GridNodeRequest(
        String nodeId,
        NodeType nodeType,
        Double latitude,
        Double longitude,
        Double currentPower
) {
}