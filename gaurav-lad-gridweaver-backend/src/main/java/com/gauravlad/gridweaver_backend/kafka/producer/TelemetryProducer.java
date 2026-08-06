package com.gauravlad.gridweaver_backend.kafka.producer;

import com.gauravlad.gridweaver_backend.entity.Telemetry;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TelemetryProducer {

    private final KafkaTemplate<String, Telemetry> kafkaTemplate;

    public void sendTelemetry(Telemetry telemetry){

        kafkaTemplate.send(
                "telemetry-topic",
                telemetry
        );
    }
}