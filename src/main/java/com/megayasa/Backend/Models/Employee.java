package com.megayasa.Backend.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name = "employee")
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Employee {
    @Id
    @Column(name = "id", length = 36, nullable = false)
    private String id;

    @Column(name = "name", length = 255, nullable = false)
    private String fullName;

    @Column(name = "birthdate", nullable = false)
    private Date birthDate;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "gender", nullable = false, length = 255)
    private String gender;

    @Column(name = "phoneNumber", nullable = true, unique = true, length = 15)
    private String phoneNumber;

    @Column(name = "identityNumber", nullable = true, unique = true, length = 255)
    private String identityNumber;

    @ManyToOne
    @JoinColumn(name = "positionId")
    private Position position;
}
