package com.megayasa.Backend.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name = "incident")
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Incident {
    @Id
    @Column(length = 36, nullable = false)
    private String id;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = true)
    private String pictureUrl;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;


}
