package com.hisistant.auth.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DailySales {
    @Id
    private int id;
    private int year;
    private int month;
    private int week;
    private int day_of_week;
    private int sales_count;
    private int sales_amount;
    @Column(name = "user_id")
    private Long userId;
}
