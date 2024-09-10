package com.hisistant.auth.repository;

import com.hisistant.auth.domain.MonthlySales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonthlySalesRepository extends JpaRepository<MonthlySales, Integer> {

    MonthlySales findFirstByUserIdOrderByMonthDesc(Long userId);
}
