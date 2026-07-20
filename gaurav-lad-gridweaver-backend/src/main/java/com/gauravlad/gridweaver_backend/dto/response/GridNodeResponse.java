package com.gauravlad.gridweaver_backend.dto.response;

import com.gauravlad.gridweaver_backend.enums.GridStatus;
import com.gauravlad.gridweaver_backend.enums.NodeType;

public record GridNodeResponse(

        Long id,
        String nodeId,
        NodeType nodeType,
        Double latitude,
        Double longitude,
        Double currentPower,
        GridStatus status

) {
}
