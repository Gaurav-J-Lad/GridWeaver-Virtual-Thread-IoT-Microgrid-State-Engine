package com.gauravlad.gridweaver_backend.service;

import com.gauravlad.gridweaver_backend.dto.request.TelemetryRequest;
import com.gauravlad.gridweaver_backend.dto.response.TelemetryResponse;
import com.gauravlad.gridweaver_backend.entity.GridNode;
import com.gauravlad.gridweaver_backend.entity.Telemetry;
import com.gauravlad.gridweaver_backend.exceptions.ResourceNotFoundException;
import com.gauravlad.gridweaver_backend.mapper.TelemetryMapper;
import com.gauravlad.gridweaver_backend.repository.GridNodeRepository;
import com.gauravlad.gridweaver_backend.repository.TelemetryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TelemetryServiceImpl implements TelemetryService {

    private final TelemetryRepository telemetryRepository;
    private final GridNodeRepository gridNodeRepository;
    private final TelemetryMapper telemetryMapper;

    @Override
    public TelemetryResponse createTelemetry(TelemetryRequest request) {

        GridNode gridNode = gridNodeRepository.findById(request.gridNodeId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Grid Node not found with id : " + request.gridNodeId()));

        Telemetry telemetry = telemetryMapper.toEntity(request, gridNode);

        Telemetry savedTelemetry = telemetryRepository.save(telemetry);

        return telemetryMapper.toResponse(savedTelemetry);
    }

    @Override
    public List<TelemetryResponse> getAllTelemetry() {

        return telemetryRepository.findAll()
                .stream()
                .map(telemetryMapper::toResponse)
                .toList();
    }

    @Override
    public TelemetryResponse getTelemetryById(Long id) {

        Telemetry telemetry = telemetryRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Telemetry not found with id : " + id));

        return telemetryMapper.toResponse(telemetry);
    }

    @Override
    public void deleteTelemetry(Long id) {

        Telemetry telemetry = telemetryRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Telemetry not found with id : " + id));

        telemetryRepository.delete(telemetry);
    }
}
