package com.megayasa.Backend.ViewModels.Responses;

import java.util.Date;

public class AbsenceDashboardResponseVm {
    private Date date;
    private int sick, present, permission, leave, alpa;

    public AbsenceDashboardResponseVm() {
    }

    public AbsenceDashboardResponseVm(Date date, int sick, int present, int permission, int leave, int alpa) {
        this.date = date;
        this.sick = sick;
        this.present = present;
        this.permission = permission;
        this.leave = leave;
        this.alpa = alpa;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSick() {
        return sick;
    }

    public void setSick(int sick) {
        this.sick = sick;
    }

    public int getPresent() {
        return present;
    }

    public void setPresent(int present) {
        this.present = present;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }

    public int getLeave() {
        return leave;
    }

    public void setLeave(int leave) {
        this.leave = leave;
    }

    public int getAlpa() {
        return alpa;
    }

    public void setAlpa(int alpa) {
        this.alpa = alpa;
    }

    @Override
    public String toString() {
        return "AbsenceDashboardResponseVm{" +
                "date=" + date +
                ", sick=" + sick +
                ", present=" + present +
                ", permission=" + permission +
                ", leave=" + leave +
                ", alpa=" + alpa +
                '}';
    }
}
