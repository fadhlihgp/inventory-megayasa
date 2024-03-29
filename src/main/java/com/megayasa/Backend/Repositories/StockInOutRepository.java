package com.megayasa.Backend.Repositories;

import com.megayasa.Backend.Models.StockInOut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StockInOutRepository extends JpaRepository<StockInOut, String> {
    @Query("select count(s) from StockInOut s where s.status = :status and s.date = CURRENT_DATE ")
    Integer countStockInOutByStatusAndToday(@Param("status") Boolean status);
}
