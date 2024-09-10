package com.hisistant.auth.repository;

import com.hisistant.auth.domain.MonthlySales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MonthlySalesRepository extends JpaRepository<MonthlySales, Integer> {

    MonthlySales findFirstByUserIdOrderByMonthDesc(Long userId);

    List<MonthlySales> findByUserId(Long userId);
}
