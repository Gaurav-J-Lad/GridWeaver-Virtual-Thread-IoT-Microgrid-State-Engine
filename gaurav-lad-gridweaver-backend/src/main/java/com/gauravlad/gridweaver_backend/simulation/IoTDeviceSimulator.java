package com.gauravlad.gridweaver_backend.simulation;

import com.gauravlad.gridweaver_backend.entity.GridNode;
import com.gauravlad.gridweaver_backend.entity.Telemetry;
import com.gauravlad.gridweaver_backend.kafka.event.TelemetryEvent;
import com.gauravlad.gridweaver_backend.kafka.producer.TelemetryProducer;
import com.gauravlad.gridweaver_backend.repository.GridNodeRepository;
import com.gauravlad.gridweaver_backend.repository.TelemetryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.Executors;

@Component
@RequiredArgsConstructor
public class IoTDeviceSimulator {

    private final GridNodeRepository gridNodeRepository;
    private final RandomTelemetryGenerator generator;
    private final TelemetryProducer telemetryProducer;

    @Scheduled(fixedRate = 5000)
    public void simulateTelemetry() {

        List<GridNode> nodes = gridNodeRepository.findAll();

        try (var executor =
                     Executors.newVirtualThreadPerTaskExecutor()) {

            for (GridNode node : nodes) {

                executor.submit(() -> {

                    double powerOutput =
                            generator.generatePowerOutput();

                    double voltage =
                            generator.generateVoltage();

                    double current =
                            generator.generateCurrent();

                    double temperature =
                            generator.generateTemperature();

                    TelemetryEvent event =
                            new TelemetryEvent(
                                    node.getId(),
                                    node.getNodeId(),
                                    powerOutput,
                                    voltage,
                                    current,
                                    temperature
                            );

                    telemetryProducer.sendTelemetry(event);

                    System.out.println(
                            "Telemetry sent for "
                                    + node.getNodeId()
                                    + " | "
                                    + Thread.currentThread()
                    );
                });
            }
        }
    }
}