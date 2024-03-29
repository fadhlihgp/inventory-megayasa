package com.megayasa.Backend.Repositories;

import com.megayasa.Backend.Models.Incident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface IncidentRepository extends JpaRepository<Incident, String> {
    @Query("SELECT COUNT(i) from Incident i WHERE i.date = CURRENT_DATE ")
    Long countIncidentToday();
}
