package com.gauravlad.gridweaver_backend.service;

import com.gauravlad.gridweaver_backend.dto.request.BatteryRequest;
import com.gauravlad.gridweaver_backend.dto.response.BatteryResponse;

import java.util.List;

public interface BatteryService {

    BatteryResponse createBattery(BatteryRequest request);

    List<BatteryResponse> getAllBatteries();

    BatteryResponse getBatteryById(Long id);

    BatteryResponse updateBattery(Long id, BatteryRequest request);

    void deleteBattery(Long id);
}