package com.gauravlad.gridweaver_backend.kafka.event;

public record TelemetryEvent(

        Long gridNodeId,
        String nodeId,

        double powerOutput,
        double voltage,
        double current,
        double temperature

) {
}