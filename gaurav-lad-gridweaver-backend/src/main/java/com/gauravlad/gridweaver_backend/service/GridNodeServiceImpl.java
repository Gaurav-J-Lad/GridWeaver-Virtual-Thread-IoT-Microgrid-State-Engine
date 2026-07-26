package com.gauravlad.gridweaver_backend.service;

import com.gauravlad.gridweaver_backend.dto.request.GridNodeRequest;
import com.gauravlad.gridweaver_backend.dto.response.GridNodeResponse;
import com.gauravlad.gridweaver_backend.entity.GridNode;
import com.gauravlad.gridweaver_backend.exceptions.DuplicateResourceException;
import com.gauravlad.gridweaver_backend.exceptions.ResourceNotFoundException;
import com.gauravlad.gridweaver_backend.mapper.GridNodeMapper;
import com.gauravlad.gridweaver_backend.repository.GridNodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GridNodeServiceImpl implements GridNodeService {

    private final GridNodeRepository gridNodeRepository;
    private final GridNodeMapper gridNodeMapper;

    @Override
    public GridNodeResponse createGridNode(GridNodeRequest request) {

        if (gridNodeRepository.existsByNodeId(request.nodeId())) {
            throw new DuplicateResourceException(
                    "Grid Node already exists with nodeId : " + request.nodeId());
        }

        GridNode gridNode = gridNodeMapper.toEntity(request);

        GridNode savedNode = gridNodeRepository.save(gridNode);

        return gridNodeMapper.toResponse(savedNode);
    }

    @Override
    public List<GridNodeResponse> getAllGridNodes() {

        return gridNodeRepository.findAll()
                .stream()
                .map(gridNodeMapper::toResponse)
                .toList();
    }

    @Override
    public GridNodeResponse getGridNodeById(Long id) {

        GridNode gridNode = gridNodeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Grid Node not found with id : " + id));

        return gridNodeMapper.toResponse(gridNode);
    }

    @Override
    public GridNodeResponse updateGridNode(Long id, GridNodeRequest request) {

        GridNode gridNode = gridNodeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Grid Node not found with id : " + id));

        gridNode.setNodeId(request.nodeId());
        gridNode.setNodeType(request.nodeType());
        gridNode.setLatitude(request.latitude());
        gridNode.setLongitude(request.longitude());
        gridNode.setCurrentPower(request.currentPower());
        gridNode.setLastUpdated(LocalDateTime.now());

        GridNode updatedNode = gridNodeRepository.save(gridNode);

        return gridNodeMapper.toResponse(updatedNode);
    }

    @Override
    public void deleteGridNode(Long id) {

        GridNode gridNode = gridNodeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Grid Node not found with id : " + id));

        gridNodeRepository.delete(gridNode);
    }
}