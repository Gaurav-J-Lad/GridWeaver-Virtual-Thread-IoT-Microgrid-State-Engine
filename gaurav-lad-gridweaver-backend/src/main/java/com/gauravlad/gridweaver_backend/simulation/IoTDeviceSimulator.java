package com.gauravlad.gridweaver_backend.simulation;

import com.gauravlad.gridweaver_backend.entity.GridNode;
import com.gauravlad.gridweaver_backend.entity.Telemetry;
import com.gauravlad.gridweaver_backend.repository.GridNodeRepository;
import com.gauravlad.gridweaver_backend.repository.TelemetryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class IoTDeviceSimulator {

    private final GridNodeRepository gridNodeRepository;
    private final TelemetryRepository telemetryRepository;
    private final RandomTelemetryGenerator generator;

    @Scheduled(fixedRate = 5000)
    public void simulateTelemetry() {

        List<GridNode> nodes = gridNodeRepository.findAll();

        try (var executor = java.util.concurrent.Executors.newVirtualThreadPerTaskExecutor()) {

            for (GridNode node : nodes) {

                executor.submit(() -> {

                    Telemetry telemetry = new Telemetry();

                    telemetry.setGridNode(node);

                    telemetry.setPowerOutput(generator.generatePowerOutput());

                    telemetry.setVoltage(generator.generateVoltage());

                    telemetry.setCurrent(generator.generateCurrent());

                    telemetry.setTemperature(generator.generateTemperature());

                    telemetry.setTimestamp(LocalDateTime.now());

                    telemetryRepository.save(telemetry);

                    System.out.println(
                            "Telemetry generated for "
                                    + node.getNodeId()
                                    + " by "
                                    + Thread.currentThread());
                });

            }

        }

    }
}