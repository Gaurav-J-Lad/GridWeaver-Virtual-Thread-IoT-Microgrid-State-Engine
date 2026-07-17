package com.gauravlad.gridweaver_backend.entity;

import com.gauravlad.gridweaver_backend.enums.BatteryState;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "batteries")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Battery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "grid_node_id", nullable = false, unique = true)
    private GridNode gridNode;

    private Double chargeLevel;

    private Double capacity;

    @Enumerated(EnumType.STRING)
    private BatteryState state;

    private Double temperature;
}
