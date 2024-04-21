package com.megayasa.Frontend.Helpers;

import com.megayasa.Backend.Models.Employee;
import com.megayasa.Backend.Models.Inventory;
import com.megayasa.Backend.Models.Position;
import com.megayasa.Backend.Models.Role;
import com.megayasa.Backend.ViewModels.Responses.EmployeeResponseVm;

import javax.swing.*;
import java.awt.*;

public class ComboBoxListCellRender extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        switch (value) {
            case Position position -> value = position.getName();
            case Employee employee -> value = employee.getId() + " - " + employee.getFullName();
            case EmployeeResponseVm employeeResponseVm -> {
                String empId = employeeResponseVm.getId() == null ? "" : employeeResponseVm.getId() + " - ";
                value = empId + employeeResponseVm.getFullName();
            }
            case Role role -> value = role.getName();
            case Inventory inventory -> {
                String code = inventory.getCode() == null ? "" : inventory.getCode() + " - ";
                value = code + inventory.getName();
            }
            case null, default -> System.out.println("Jenis objek tidak dikenali: " + value);
        }
//        switch (value) {
//            case Position position -> value = position.getName();
//            case Employee employee -> value = employee.getId() + " - " + employee.getFullName();
//            case Role role -> value = role.getName();
//            case Inventory inventory -> value = inventory.getCode() + " - " + inventory.getName();
//            default -> System.out.println("Jenis objek tidak dikenali: " + value);
//        }
        return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
    }
}
