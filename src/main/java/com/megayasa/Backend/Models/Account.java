package com.megayasa.Backend.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name = "account")
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Account {
    @Id
    @Column(length = 36, name = "id", nullable = false)
    private String id;

    @Column(name = "username", unique = true, nullable = false, length = 255)
    private String username;

    @Column(name = "email", unique = true, nullable = false, length = 255)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "fullName", nullable = false, length = 255)
    private String fullName;

    @Column(name = "phoneNumber", nullable = true, length = 15)
    private String phoneNumber;

    @Column(name = "lastLogin", nullable = true)
    private Date lastLogin;

    @Column(name = "isActive", nullable = false)
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "roleId", nullable = false)
    private Role role;

    @OneToOne
    @JoinColumn(name = "employeeId", nullable = true)
    private Employee employee;
}
