package com.gauravlad.gridweaver_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "telemetry")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Telemetry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "grid_node_id")
    private GridNode gridNode;

    private Double powerOutput;

    private Double voltage;

    private Double current;

    private Double temperature;

    private LocalDateTime timestamp;
}
