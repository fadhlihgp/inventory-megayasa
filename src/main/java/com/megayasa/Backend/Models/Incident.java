package com.megayasa.Backend.Models;

import com.megayasa.Backend.Annotations.Db.Column;
import com.megayasa.Backend.Annotations.Db.Id;
import com.megayasa.Backend.Annotations.Db.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name = "incident")
@Data @AllArgsConstructor @NoArgsConstructor
public class Incident {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "date")
    private Date date;

    @Column(name = "picture_url")
    private String pictureUrl;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;
}
