package com.gauravlad.gridweaver_backend.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic telemetryTopic() {

        return new NewTopic(
                "telemetry-topic",
                1,
                (short) 1
        );
    }
}