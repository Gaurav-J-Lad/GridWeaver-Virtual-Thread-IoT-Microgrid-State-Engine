package com.gauravlad.gridweaver_backend.controller;

import com.gauravlad.gridweaver_backend.dto.request.BatteryRequest;
import com.gauravlad.gridweaver_backend.dto.response.BatteryResponse;
import com.gauravlad.gridweaver_backend.service.BatteryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/batteries")
@RequiredArgsConstructor
public class BatteryController {

    private final BatteryService batteryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BatteryResponse createBattery(@Valid @RequestBody BatteryRequest request) {

        return batteryService.createBattery(request);
    }

    @GetMapping
    public List<BatteryResponse> getAllBatteries() {

        return batteryService.getAllBatteries();
    }

    @GetMapping("/{id}")
    public BatteryResponse getBatteryById(@PathVariable Long id) {

        return batteryService.getBatteryById(id);
    }

    @PutMapping("/{id}")
    public BatteryResponse updateBattery(
            @PathVariable Long id,
            @Valid @RequestBody BatteryRequest request) {

        return batteryService.updateBattery(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBattery(@PathVariable Long id) {

        batteryService.deleteBattery(id);
    }
}
