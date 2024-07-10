package com.megayasa.Backend.ViewModels.Responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbsenceDetailResponseVm {
    private String id, employeeId, employeeName, information, note;
    private Date date;
}
