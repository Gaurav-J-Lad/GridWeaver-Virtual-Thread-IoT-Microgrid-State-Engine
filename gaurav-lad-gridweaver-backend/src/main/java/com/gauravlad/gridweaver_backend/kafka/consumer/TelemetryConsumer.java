package com.gauravlad.gridweaver_backend.kafka.consumer;

import com.gauravlad.gridweaver_backend.entity.Telemetry;
import com.gauravlad.gridweaver_backend.repository.TelemetryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TelemetryConsumer {

    private final TelemetryRepository telemetryRepository;

    @KafkaListener(
            topics = "telemetry-topic",
            groupId = "gridweaver-group"
    )
    public void consume(Telemetry telemetry){

        telemetryRepository.save(telemetry);

        System.out.println(
                "Telemetry Saved : "
                        + telemetry.getGridNode().getNodeId()
        );
    }
}