package com.gauravlad.gridweaver_backend.repository;

import com.gauravlad.gridweaver_backend.entity.GridNode;
import com.gauravlad.gridweaver_backend.entity.Telemetry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TelemetryRepository extends JpaRepository<Telemetry, Long> {

    List<Telemetry> findByGridNode(GridNode gridNode);

}
