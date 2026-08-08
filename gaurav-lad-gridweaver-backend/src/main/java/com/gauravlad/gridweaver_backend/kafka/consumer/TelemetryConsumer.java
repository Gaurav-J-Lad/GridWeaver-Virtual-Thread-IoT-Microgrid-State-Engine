package com.gauravlad.gridweaver_backend.kafka.consumer;

import com.gauravlad.gridweaver_backend.entity.GridNode;
import com.gauravlad.gridweaver_backend.entity.Telemetry;
import com.gauravlad.gridweaver_backend.kafka.event.TelemetryEvent;
import com.gauravlad.gridweaver_backend.repository.GridNodeRepository;
import com.gauravlad.gridweaver_backend.repository.TelemetryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TelemetryConsumer {

    private final TelemetryRepository telemetryRepository;
    private final GridNodeRepository gridNodeRepository;

    @KafkaListener(
            topics = "telemetry-topic",
            groupId = "gridweaver-group"
    )
    public void consume(TelemetryEvent event) {

        GridNode gridNode =
                gridNodeRepository.findById(event.gridNodeId())
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Grid Node not found: "
                                                + event.gridNodeId()
                                ));

        Telemetry telemetry = new Telemetry();

        telemetry.setGridNode(gridNode);
        telemetry.setPowerOutput(event.powerOutput());
        telemetry.setVoltage(event.voltage());
        telemetry.setCurrent(event.current());
        telemetry.setTemperature(event.temperature());
        telemetry.setTimestamp(LocalDateTime.now());

        telemetryRepository.save(telemetry);

        System.out.println(
                "Telemetry saved for "
                        + event.nodeId()
        );
    }
}