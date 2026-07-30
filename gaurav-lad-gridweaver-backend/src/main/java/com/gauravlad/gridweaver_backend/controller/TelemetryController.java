package com.gauravlad.gridweaver_backend.controller;

import com.gauravlad.gridweaver_backend.dto.request.TelemetryRequest;
import com.gauravlad.gridweaver_backend.dto.response.TelemetryResponse;
import com.gauravlad.gridweaver_backend.service.TelemetryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/telemetry")
@RequiredArgsConstructor
public class TelemetryController {

    private final TelemetryService telemetryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TelemetryResponse createTelemetry(@Valid @RequestBody TelemetryRequest request) {

        return telemetryService.createTelemetry(request);
    }

    @GetMapping
    public List<TelemetryResponse> getAllTelemetry() {

        return telemetryService.getAllTelemetry();
    }

    @GetMapping("/{id}")
    public TelemetryResponse getTelemetryById(@PathVariable Long id) {

        return telemetryService.getTelemetryById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTelemetry(@PathVariable Long id) {

        telemetryService.deleteTelemetry(id);
    }
}