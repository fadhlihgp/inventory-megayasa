package com.megayasa.Backend.Services;

import com.google.inject.Inject;
import com.megayasa.Backend.Context.TransactionUtil;
import com.megayasa.Backend.Repositories.AbsenceRepository;
import com.megayasa.Backend.Repositories.EmployeeRepository;
import com.megayasa.Backend.Repositories.IncidentRepository;
import com.megayasa.Backend.Repositories.StockInOutRepository;
import com.megayasa.Backend.Services.Interfaces.DashboardService;
import com.megayasa.Backend.ViewModels.Responses.DashboardResponseVm;

public class DashboardServiceImpl implements DashboardService {
    private final EmployeeRepository employeeRepository;
    private final AbsenceRepository absenceRepository;
    private final IncidentRepository incidentRepository;
    private final StockInOutRepository stockInOutRepository;

    @Inject
    public DashboardServiceImpl(EmployeeRepository employeeRepository, AbsenceRepository absenceRepository, IncidentRepository incidentRepository, StockInOutRepository stockInOutRepository) {
        this.employeeRepository = employeeRepository;
        this.absenceRepository = absenceRepository;
        this.incidentRepository = incidentRepository;
        this.stockInOutRepository = stockInOutRepository;
    }


    @Override
    public DashboardResponseVm getDashboard() {
        DashboardResponseVm dashboardResponseVm = new DashboardResponseVm();
        TransactionUtil.performTransaction(() -> {
            dashboardResponseVm.setEmployeeTotal(employeeRepository.countAllEmployee());
            dashboardResponseVm.setIncidentTotal(incidentRepository.countIncidentMonthNow());
            dashboardResponseVm.setTransactionTotal(stockInOutRepository.countByNowMonth());
            dashboardResponseVm.setAbsences(absenceRepository.absenceDashboard());
            dashboardResponseVm.setTransactions(stockInOutRepository.stockInOutDashboard());
        });
        return dashboardResponseVm;
    }
}
