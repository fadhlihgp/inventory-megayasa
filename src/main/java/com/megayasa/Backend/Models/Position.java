package com.megayasa.Backend.Models;

import com.megayasa.Backend.Annotations.Db.Column;
import com.megayasa.Backend.Annotations.Db.Id;
import com.megayasa.Backend.Annotations.Db.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table(name = "position")
@Data @AllArgsConstructor @NoArgsConstructor
public class Position {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;
}
