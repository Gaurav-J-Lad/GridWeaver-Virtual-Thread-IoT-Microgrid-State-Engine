package com.gauravlad.gridweaver_backend.service;

import com.gauravlad.gridweaver_backend.dto.request.GridNodeRequest;
import com.gauravlad.gridweaver_backend.dto.response.GridNodeResponse;

import java.util.List;

public interface GridNodeService {

    GridNodeResponse createGridNode(GridNodeRequest request);

    List<GridNodeResponse> getAllGridNodes();

    GridNodeResponse getGridNodeById(Long id);

    GridNodeResponse updateGridNode(Long id, GridNodeRequest request);

    void deleteGridNode(Long id);
}