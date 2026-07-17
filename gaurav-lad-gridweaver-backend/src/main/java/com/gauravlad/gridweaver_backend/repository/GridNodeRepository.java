package com.gauravlad.gridweaver_backend.repository;

import com.gauravlad.gridweaver_backend.entity.GridNode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GridNodeRepository extends JpaRepository<GridNode, Long> {

    Optional<GridNode> findByNodeId(String nodeId);

    boolean existsByNodeId(String nodeId);

}