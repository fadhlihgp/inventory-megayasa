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
        if (value instanceof Position) {
            value = ((Position) value).getName();
        } else if (value instanceof Employee employee) {
            value = employee.getId() + " - " + employee.getFullName();
        } else if (value instanceof EmployeeResponseVm employeeResponseVm) {
            String empId = employeeResponseVm.getId() == null ? "" : employeeResponseVm.getId() + " - ";
            value = empId + employeeResponseVm.getFullName();
        } else if (value instanceof Role) {
            value = ((Role) value).getName();
        } else if (value instanceof Inventory inventory) {
            String code = inventory.getCode() == null ? "" : inventory.getCode() + " - ";
            value = code + inventory.getName();
        } else if (value == null) {
            System.out.println("Jenis objek tidak dikenali: " + value);
        } else {
            System.out.println("Jenis objek tidak dikenali: " + value.getClass().getName());
        }

        return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
    }
}
