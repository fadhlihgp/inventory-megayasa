package com.megayasa.Backend.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

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

    @Column(name = "phone_number", nullable = true, unique = true, length = 15)
    private String phoneNumber;

    @Column(name = "identity_number", nullable = true, unique = true)
    private String identityNumber;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Absence> absences;
}
