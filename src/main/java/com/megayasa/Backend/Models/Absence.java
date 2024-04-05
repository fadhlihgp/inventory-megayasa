package com.megayasa.Backend.Models;
import com.megayasa.Backend.Annotations.Db.Column;
import com.megayasa.Backend.Annotations.Db.Id;
import com.megayasa.Backend.Annotations.Db.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name = "absence")
@Data @AllArgsConstructor @NoArgsConstructor
public class Absence {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "date")
    private Date date;

    @Column(name = "information")
    private String information;

    @Column(name = "note")
    private String note;

    @Column(name = "employee_id")
    private String employeeId;
}
