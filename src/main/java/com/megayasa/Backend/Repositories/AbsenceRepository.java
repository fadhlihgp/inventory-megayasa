package com.megayasa.Backend.Repositories;

import com.megayasa.Backend.Models.Absence;
import com.megayasa.Backend.ViewModels.Responses.AbsenceResponseVm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AbsenceRepository extends JpaRepository<Absence, String> {
    @Query("select e.id as employeeId, e.fullName as employeeName, " +
            "nullif(sum(case when a.information = 'Cuti' then 1 else 0 end ), 0) as leave, " +
            "nullif(sum(case when a.information = 'Izin' then 1 else 0 end ), 0) as permission, " +
            "nullif(sum(case when a.information = 'Sakit' then 1 else 0 end ), 0) as sick, " +
            "nullif(sum(case when a.information = 'Alpa' then 1 else 0 end ), 0) as alpha " +
            "from Employee e " +
            "left join Absence  a on e.id = a.employee.id " +
            "group by e.id")
    List<AbsenceResponseVm> absenceList();
}
