package com.megayasa.Backend.ViewModels.Responses;

import lombok.Data;

import java.util.Date;

@Data
public class EmployeeResponseVm {
    private String id;
    private String identityNumber;
    private String fullName;
    private Date birthDate;
    private String address;
    private String gender;
    private String phoneNumber;
    private String positionId;
    private String position;
    private boolean isActive;
}
