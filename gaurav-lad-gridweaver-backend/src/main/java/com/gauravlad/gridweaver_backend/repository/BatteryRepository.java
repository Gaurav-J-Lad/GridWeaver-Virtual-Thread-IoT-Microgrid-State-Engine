package com.gauravlad.gridweaver_backend.repository;

import com.gauravlad.gridweaver_backend.entity.Battery;
import com.gauravlad.gridweaver_backend.entity.GridNode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BatteryRepository extends JpaRepository<Battery, Long> {

    Optional<Battery> findByGridNode(GridNode gridNode);

}
