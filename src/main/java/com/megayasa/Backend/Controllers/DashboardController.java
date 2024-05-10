package com.megayasa.Backend.Controllers;

import com.google.inject.Inject;
import com.megayasa.Backend.Services.Interfaces.DashboardService;
import com.megayasa.Backend.ViewModels.Responses.DashboardResponseVm;

public class DashboardController {
    private final DashboardService dashboardService;

    @Inject
    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    public DashboardResponseVm getDashboard() {
        return dashboardService.getDashboard();
    }
}
