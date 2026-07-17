package com.gauravlad.gridweaver_backend.repository;

import com.gauravlad.gridweaver_backend.entity.EventLog;
import com.gauravlad.gridweaver_backend.entity.GridNode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventLogRepository extends JpaRepository<EventLog, Long> {

    List<EventLog> findByGridNode(GridNode gridNode);

}