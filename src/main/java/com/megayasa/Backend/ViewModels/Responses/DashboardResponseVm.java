package com.megayasa.Backend.ViewModels.Responses;

import java.util.List;

public class DashboardResponseVm {
    private int employeeTotal, transactionTotal, incidentTotal;
    private List<AbsenceDashboardResponseVm> absences;
    private List<StockInOutDashboardResponseVm> transactions;

    public DashboardResponseVm() {
    }

    public DashboardResponseVm(int employeeTotal, int transactionTotal, int incidentTotal, List<AbsenceDashboardResponseVm> absences, List<StockInOutDashboardResponseVm> transactions) {
        this.employeeTotal = employeeTotal;
        this.transactionTotal = transactionTotal;
        this.incidentTotal = incidentTotal;
        this.absences = absences;
        this.transactions = transactions;
    }

    public int getEmployeeTotal() {
        return employeeTotal;
    }

    public void setEmployeeTotal(int employeeTotal) {
        this.employeeTotal = employeeTotal;
    }

    public int getTransactionTotal() {
        return transactionTotal;
    }

    public void setTransactionTotal(int transactionTotal) {
        this.transactionTotal = transactionTotal;
    }

    public int getIncidentTotal() {
        return incidentTotal;
    }

    public void setIncidentTotal(int incidentTotal) {
        this.incidentTotal = incidentTotal;
    }

    public List<AbsenceDashboardResponseVm> getAbsences() {
        return absences;
    }

    public void setAbsences(List<AbsenceDashboardResponseVm> absences) {
        this.absences = absences;
    }

    public List<StockInOutDashboardResponseVm> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<StockInOutDashboardResponseVm> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "DashboardResponseVm{" +
                "employeeTotal=" + employeeTotal +
                ", transactionTotal=" + transactionTotal +
                ", incidentTotal=" + incidentTotal +
                ", absences=" + absences +
                ", transactions=" + transactions +
                '}';
    }
}
