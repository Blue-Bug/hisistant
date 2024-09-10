package com.hisistant.auth.repository;

import com.hisistant.auth.domain.DailySales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DailySalesRepository extends JpaRepository<DailySales,Integer> {

    List<DailySales> findByUserId(Long user_id);
}
