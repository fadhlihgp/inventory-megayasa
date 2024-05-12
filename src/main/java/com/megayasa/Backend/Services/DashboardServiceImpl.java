package com.megayasa.Backend.Services;

import com.google.inject.Inject;
import com.megayasa.Backend.Context.TransactionUtil;
import com.megayasa.Backend.Repositories.*;
import com.megayasa.Backend.Services.Interfaces.DashboardService;
import com.megayasa.Backend.ViewModels.Responses.DashboardResponseVm;

public class DashboardServiceImpl implements DashboardService {
    private final EmployeeRepository employeeRepository;
    private final AbsenceRepository absenceRepository;
    private final IncidentRepository incidentRepository;
    private final StockInOutRepository stockInOutRepository;
    private final InventoryRepository inventoryRepository;

    @Inject
    public DashboardServiceImpl(EmployeeRepository employeeRepository, AbsenceRepository absenceRepository, IncidentRepository incidentRepository, StockInOutRepository stockInOutRepository, InventoryRepository inventoryRepository) {
        this.employeeRepository = employeeRepository;
        this.absenceRepository = absenceRepository;
        this.incidentRepository = incidentRepository;
        this.stockInOutRepository = stockInOutRepository;
        this.inventoryRepository = inventoryRepository;
    }


    @Override
    public DashboardResponseVm getDashboard() {
        DashboardResponseVm dashboardResponseVm = new DashboardResponseVm();
        TransactionUtil.performTransaction(() -> {
            dashboardResponseVm.setEmployeeTotal(employeeRepository.countAllEmployee());
            dashboardResponseVm.setIncidentTotal(incidentRepository.countIncidentMonthNow());
            dashboardResponseVm.setTransactionTotal(stockInOutRepository.countByNowMonth());
            dashboardResponseVm.setInventoryTotal(inventoryRepository.inventoryTotal());
            dashboardResponseVm.setAbsences(absenceRepository.absenceDashboard());
            dashboardResponseVm.setTransactions(stockInOutRepository.stockInOutDashboard());
        });
        return dashboardResponseVm;
    }
}
