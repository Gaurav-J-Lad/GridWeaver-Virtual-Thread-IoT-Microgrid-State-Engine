package com.gauravlad.gridweaver_backend.kafka.producer;

import com.gauravlad.gridweaver_backend.entity.Telemetry;
import com.gauravlad.gridweaver_backend.kafka.event.TelemetryEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TelemetryProducer {

    private static final String TOPIC = "telemetry-topic";

    private final KafkaTemplate<String, TelemetryEvent> kafkaTemplate;

    public void sendTelemetry(TelemetryEvent event) {

        kafkaTemplate.send(
                TOPIC,
                event.nodeId(),
                event
        );
    }
}