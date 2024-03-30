package com.megayasa.Backend.ViewModels.Requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbsenceRequestVm {
    private String employeeId;
    private Date date;
    private String information;
    private String note;
}
