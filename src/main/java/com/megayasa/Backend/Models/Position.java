package com.megayasa.Backend.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "position")
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Position {
    @Id
    @Column(name = "id", length = 36, nullable = false)
    private String id;

    @Column(nullable = false, name = "name")
    private String name;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private List<Employee> employees;
}