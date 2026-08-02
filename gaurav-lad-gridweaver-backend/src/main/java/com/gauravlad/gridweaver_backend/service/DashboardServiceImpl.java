package com.gauravlad.gridweaver_backend.service;

import com.gauravlad.gridweaver_backend.dto.response.DashboardResponse;
import com.gauravlad.gridweaver_backend.enums.BatteryState;
import com.gauravlad.gridweaver_backend.enums.GridStatus;
import com.gauravlad.gridweaver_backend.enums.NodeType;
import com.gauravlad.gridweaver_backend.repository.BatteryRepository;
import com.gauravlad.gridweaver_backend.repository.GridNodeRepository;
import com.gauravlad.gridweaver_backend.repository.TelemetryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DashboardServiceImpl implements DashboardService {

    private final GridNodeRepository gridNodeRepository;
    private final BatteryRepository batteryRepository;
    private final TelemetryRepository telemetryRepository;

    @Override
    public DashboardResponse getDashboard() {

        return new DashboardResponse(

                gridNodeRepository.count(),

                gridNodeRepository.countByStatus(GridStatus.ONLINE),

                gridNodeRepository.countByStatus(GridStatus.OFFLINE),

                gridNodeRepository.countByNodeType(NodeType.BATTERY),

                batteryRepository.countByState(BatteryState.CHARGING),

                batteryRepository.countByState(BatteryState.DISCHARGING),

                batteryRepository.countByState(BatteryState.IDLE),

                batteryRepository.countByState(BatteryState.FAULT),

                telemetryRepository.getTotalPowerGenerated()

        );
    }}