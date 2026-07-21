package com.gauravlad.gridweaver_backend.mapper;

import com.gauravlad.gridweaver_backend.dto.request.GridNodeRequest;
import com.gauravlad.gridweaver_backend.dto.response.GridNodeResponse;
import com.gauravlad.gridweaver_backend.entity.GridNode;
import com.gauravlad.gridweaver_backend.enums.GridStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class GridNodeMapper {

    public GridNode toEntity(GridNodeRequest request) {

        return GridNode.builder()
                .nodeId(request.nodeId())
                .nodeType(request.nodeType())
                .latitude(request.latitude())
                .longitude(request.longitude())
                .currentPower(request.currentPower())
                .status(GridStatus.ONLINE)
                .lastUpdated(LocalDateTime.now())
                .build();
    }

    public GridNodeResponse toResponse(GridNode entity) {

        return new GridNodeResponse(
                entity.getId(),
                entity.getNodeId(),
                entity.getNodeType(),
                entity.getLatitude(),
                entity.getLongitude(),
                entity.getCurrentPower(),
                entity.getStatus()
        );
    }
}