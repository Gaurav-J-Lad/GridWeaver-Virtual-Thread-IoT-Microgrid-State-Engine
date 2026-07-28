package com.gauravlad.gridweaver_backend.service;

import com.gauravlad.gridweaver_backend.dto.request.BatteryRequest;
import com.gauravlad.gridweaver_backend.dto.response.BatteryResponse;
import com.gauravlad.gridweaver_backend.entity.Battery;
import com.gauravlad.gridweaver_backend.entity.GridNode;
import com.gauravlad.gridweaver_backend.exceptions.ResourceNotFoundException;
import com.gauravlad.gridweaver_backend.mapper.BatteryMapper;
import com.gauravlad.gridweaver_backend.repository.BatteryRepository;
import com.gauravlad.gridweaver_backend.repository.GridNodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BatteryServiceImpl implements BatteryService {

    private final BatteryRepository batteryRepository;
    private final GridNodeRepository gridNodeRepository;
    private final BatteryMapper batteryMapper;

    @Override
    public BatteryResponse createBattery(BatteryRequest request) {

        GridNode gridNode = gridNodeRepository.findById(request.gridNodeId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Grid Node not found with id : " + request.gridNodeId()));

        Battery battery = batteryMapper.toEntity(request, gridNode);

        Battery savedBattery = batteryRepository.save(battery);

        return batteryMapper.toResponse(savedBattery);
    }

    @Override
    public List<BatteryResponse> getAllBatteries() {

        return batteryRepository.findAll()
                .stream()
                .map(batteryMapper::toResponse)
                .toList();
    }

    @Override
    public BatteryResponse getBatteryById(Long id) {

        Battery battery = batteryRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Battery not found with id : " + id));

        return batteryMapper.toResponse(battery);
    }

    @Override
    public BatteryResponse updateBattery(Long id, BatteryRequest request) {

        Battery battery = batteryRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Battery not found with id : " + id));

        battery.setChargeLevel(request.chargeLevel());
        battery.setCapacity(request.capacity());
        battery.setTemperature(request.temperature());

        Battery updatedBattery = batteryRepository.save(battery);

        return batteryMapper.toResponse(updatedBattery);
    }

    @Override
    public void deleteBattery(Long id) {

        Battery battery = batteryRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Battery not found with id : " + id));

        batteryRepository.delete(battery);
    }
}