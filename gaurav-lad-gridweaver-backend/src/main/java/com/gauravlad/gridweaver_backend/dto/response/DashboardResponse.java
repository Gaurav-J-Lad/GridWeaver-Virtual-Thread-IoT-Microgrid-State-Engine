package com.gauravlad.gridweaver_backend.dto.response;
public record DashboardResponse(

        long totalGridNodes,
        long onlineGridNodes,
        long offlineGridNodes,

        long totalBatteries,
        long chargingBatteries,
        long dischargingBatteries,
        long idleBatteries,
        long faultBatteries,

        double totalPowerOutput
) {}