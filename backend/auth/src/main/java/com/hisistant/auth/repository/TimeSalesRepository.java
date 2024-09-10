package com.hisistant.auth.repository;

import com.hisistant.auth.domain.TimeSales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeSalesRepository extends JpaRepository<TimeSales, Long> {
    List<TimeSales> findByUserId(Long userId);

    TimeSales findFirstByUserIdOrderByDateDesc(Long userId);
}
