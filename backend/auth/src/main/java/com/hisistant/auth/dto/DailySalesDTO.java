package com.hisistant.auth.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DailySalesDTO {
    private int id;
    private int year;
    private int month;
    private int week;
    private int day_of_week;
    private int sales_count;
    private int sales_amount;
}
