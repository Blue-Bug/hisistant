package com.hisistant.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MonthlySalesDTO {
    private int id;
    private int year;
    private int month;
    private int sales_count;
    private int sales_amount;
}
