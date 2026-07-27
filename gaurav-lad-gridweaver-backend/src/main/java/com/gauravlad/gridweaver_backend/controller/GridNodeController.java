package com.gauravlad.gridweaver_backend.controller;

import com.gauravlad.gridweaver_backend.dto.request.GridNodeRequest;
import com.gauravlad.gridweaver_backend.dto.response.GridNodeResponse;
import com.gauravlad.gridweaver_backend.service.GridNodeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grid-nodes")
@RequiredArgsConstructor
public class GridNodeController {

    private final GridNodeService gridNodeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GridNodeResponse createGridNode(
            @Valid @RequestBody GridNodeRequest request) {

        return gridNodeService.createGridNode(request);
    }

    @GetMapping
    public List<GridNodeResponse> getAllGridNodes() {

        return gridNodeService.getAllGridNodes();
    }

    @GetMapping("/{id}")
    public GridNodeResponse getGridNodeById(@PathVariable Long id) {

        return gridNodeService.getGridNodeById(id);
    }

    @PutMapping("/{id}")
    public GridNodeResponse updateGridNode(
            @PathVariable Long id,
            @Valid @RequestBody GridNodeRequest request) {

        return gridNodeService.updateGridNode(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGridNode(@PathVariable Long id) {

        gridNodeService.deleteGridNode(id);
    }
}
