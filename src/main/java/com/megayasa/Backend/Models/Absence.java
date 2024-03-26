package com.megayasa.Backend.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name = "absence")
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Absence {
    @Id
    @Column(name = "id", length = 36, nullable = false)
    private String id;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "information", nullable = false, length = 255)
    private String information;

    @Column(name = "note", nullable = true)
    private String note;

    @ManyToOne
    @JoinColumn(name = "employeeId", nullable = false)
    private Employee employee;
}
