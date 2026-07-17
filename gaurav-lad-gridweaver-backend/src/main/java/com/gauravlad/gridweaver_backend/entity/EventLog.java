package com.gauravlad.gridweaver_backend.entity;

import com.gauravlad.gridweaver_backend.enums.EventType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "event_logs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "grid_node_id")
    private GridNode gridNode;

    @Enumerated(EnumType.STRING)
    private EventType eventType;

    @Column(length = 500)
    private String description;

    private LocalDateTime createdAt;
}
