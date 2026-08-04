package com.gauravlad.gridweaver_backend.simulation;

import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
public class RandomTelemetryGenerator {

    public double generatePowerOutput() {

        return ThreadLocalRandom.current()
                .nextDouble(250, 600);
    }

    public double generateVoltage() {

        return ThreadLocalRandom.current()
                .nextDouble(220, 240);
    }

    public double generateCurrent() {

        return ThreadLocalRandom.current()
                .nextDouble(3, 8);
    }

    public double generateTemperature() {

        return ThreadLocalRandom.current()
                .nextDouble(20, 45);
    }

}
