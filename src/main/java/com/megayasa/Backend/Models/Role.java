package com.megayasa.Backend.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "role")
@Entity
@Data@AllArgsConstructor @NoArgsConstructor
public class Role {
    @Id
    @Column(length = 36, name = "id", nullable = false)
    private String id;

    @Column(name = "name", nullable = false )
    private String name;
}
