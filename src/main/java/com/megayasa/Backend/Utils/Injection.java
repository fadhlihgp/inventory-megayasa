package com.megayasa.Backend.Utils;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.megayasa.Backend.Context.AppDbContext;
import com.megayasa.Backend.Context.AppDbContextConnectionProvider;
import com.megayasa.Backend.Context.DbPersistenceProvider;
import com.megayasa.Backend.Context.Interfaces.Persistence;
import com.megayasa.Backend.Controllers.*;
import com.megayasa.Backend.Repositories.*;
import com.megayasa.Backend.Repositories.Impl.*;
import com.megayasa.Backend.Services.*;
import com.megayasa.Backend.Services.Interfaces.*;

import java.sql.Connection;

public class Injection extends AbstractModule {
    @Override
    protected void configure() {

        bind(AppDbContext.class).toInstance(new AppDbContext());
        bind(Connection.class).toProvider(AppDbContextConnectionProvider.class).in(Singleton.class);
        bind(Persistence.class).toProvider(DbPersistenceProvider.class).in(Singleton.class);

        // Repository
        bind(AccountRepository.class).to(AccountRepositoryImpl.class).in(Singleton.class);
        bind(EmployeeRepository.class).to(EmployeeRepositoryImpl.class).in(Singleton.class);
        bind(PositionRepository.class).to(PositionRepositoryImpl.class).in(Singleton.class);
        bind(AbsenceRepository.class).to(AbsenceRepositoryImpl.class).in(Singleton.class);
        bind(IncidentRepository.class).to(IncidentRepositoryImpl.class).in(Singleton.class);
        bind(InventoryRepository.class).to(InventoryRepositoryImpl.class).in(Singleton.class);
        bind(RoleRepository.class).to(RoleRepositoryImpl.class).in(Singleton.class);
        bind(StockInOutRepository.class).to(StockInOutRepositoryImpl.class).in(Singleton.class);
        bind(LoginInformationRepository.class).to(LoginInformationRepositoryImpl.class).in(Singleton.class);

        // Service
        bind(LoginService.class).to(LoginServiceImpl.class).in(Singleton.class);
        bind(AccountService.class).to(AccountServiceImpl.class).in(Singleton.class);
        bind(EmployeeService.class).to(EmployeeServiceImpl.class).in(Singleton.class);
        bind(PositionService.class).to(PositionServiceImpl.class).in(Singleton.class);
        bind(AbsenceService.class).to(AbsenceServiceImpl.class).in(Singleton.class);
        bind(IncidentService.class).to(IncidentServiceImpl.class).in(Singleton.class);
        bind(InventoryService.class).to(InventoryServiceImpl.class).in(Singleton.class);
        bind(RoleService.class).to(RoleServiceImpl.class).in(Singleton.class);
        bind(StockInOutService.class).to(StockInOutServiceImpl.class).in(Singleton.class);
        bind(LoginInformationService.class).to(LoginInformationServiceImpl.class).in(Singleton.class);
        bind(DashboardService.class).to(DashboardServiceImpl.class).in(Singleton.class);

        //Controller
        bind(LoginController.class).in(Singleton.class);
        bind(AccountController.class).in(Singleton.class);
        bind(EmployeeController.class).in(Singleton.class);
        bind(PositionController.class).in(Singleton.class);
        bind(AbsenceController.class).in(Singleton.class);
        bind(IncidentController.class).in(Singleton.class);
        bind(InventoryController.class).in(Singleton.class);
        bind(RoleController.class).in(Singleton.class);
        bind(StockInOutController.class).in(Singleton.class);
        bind(LoginInformationController.class).in(Singleton.class);
        bind(DashboardController.class).in(Singleton.class);
    }
}
