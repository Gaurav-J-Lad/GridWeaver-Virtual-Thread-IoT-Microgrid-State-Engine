package com.gauravlad.gridweaver_backend.service;

import com.gauravlad.gridweaver_backend.dto.request.TelemetryRequest;
import com.gauravlad.gridweaver_backend.dto.response.TelemetryResponse;

import java.util.List;

public interface TelemetryService {

    TelemetryResponse createTelemetry(TelemetryRequest request);

    List<TelemetryResponse> getAllTelemetry();

    TelemetryResponse getTelemetryById(Long id);

    void deleteTelemetry(Long id);
}
