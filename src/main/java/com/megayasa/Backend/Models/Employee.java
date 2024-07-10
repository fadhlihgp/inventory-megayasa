package com.megayasa.Backend.Models;

import com.megayasa.Backend.Annotations.Db.Column;
import com.megayasa.Backend.Annotations.Db.Id;
import com.megayasa.Backend.Annotations.Db.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Table(name = "employee")
@Data @AllArgsConstructor @NoArgsConstructor
public class Employee {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String fullName;

    @Column(name = "birthdate")
    private Date birthDate;

    @Column(name = "address")
    private String address;

    @Column(name = "gender")
    private String gender;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "identity_number")
    private String identityNumber;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "position_id")
    private String positionId;
}
