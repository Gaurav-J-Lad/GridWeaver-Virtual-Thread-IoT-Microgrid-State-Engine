package com.gauravlad.gridweaver_backend.dto.response;

import com.gauravlad.gridweaver_backend.enums.BatteryState;

public record BatteryResponse(

        Long id,
        Double chargeLevel,
        Double capacity,
        BatteryState state,
        Double temperature

) {
}