package com.gauravlad.gridweaver_backend.mapper;


import com.gauravlad.gridweaver_backend.dto.request.BatteryRequest;
import com.gauravlad.gridweaver_backend.dto.response.BatteryResponse;
import com.gauravlad.gridweaver_backend.entity.Battery;
import com.gauravlad.gridweaver_backend.entity.GridNode;
import com.gauravlad.gridweaver_backend.enums.BatteryState;
import org.springframework.stereotype.Component;

@Component
public class BatteryMapper {

    public Battery toEntity(BatteryRequest request, GridNode gridNode) {

        return Battery.builder()
                .gridNode(gridNode)
                .chargeLevel(request.chargeLevel())
                .capacity(request.capacity())
                .temperature(request.temperature())
                .state(BatteryState.IDLE)
                .build();
    }

    public BatteryResponse toResponse(Battery battery) {

        return new BatteryResponse(
                battery.getId(),
                battery.getChargeLevel(),
                battery.getCapacity(),
                battery.getState(),
                battery.getTemperature()
        );
    }
}