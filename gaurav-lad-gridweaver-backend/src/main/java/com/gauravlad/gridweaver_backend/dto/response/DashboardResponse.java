package com.gauravlad.gridweaver_backend.dto.response;
public record DashboardResponse(

        Long totalNodes,
        Long onlineNodes,
        Long offlineNodes,
        Long batteryNodes,
        Long chargingBatteries,
        Long dischargingBatteries,
        Long idleBatteries,
        Long faultBatteries,
        Double totalPowerGenerated

) {
}