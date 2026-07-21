package com.gauravlad.gridweaver_backend.mapper;

import com.gauravlad.gridweaver_backend.dto.response.EventLogResponse;
import com.gauravlad.gridweaver_backend.entity.EventLog;
import org.springframework.stereotype.Component;

@Component
public class EventLogMapper {

    public EventLogResponse toResponse(EventLog eventLog) {

        return new EventLogResponse(
                eventLog.getId(),
                eventLog.getEventType(),
                eventLog.getDescription(),
                eventLog.getCreatedAt()
        );
    }
}