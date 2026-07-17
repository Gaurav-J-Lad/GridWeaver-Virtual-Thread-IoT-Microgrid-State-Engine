package com.gauravlad.gridweaver_backend.entity;

import com.gauravlad.gridweaver_backend.enums.GridStatus;
import com.gauravlad.gridweaver_backend.enums.NodeType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "grid_nodes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GridNode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nodeId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NodeType nodeType;

    private Double latitude;

    private Double longitude;

    private Double currentPower;

    @Enumerated(EnumType.STRING)
    private GridStatus status;

    private LocalDateTime lastUpdated;
}
