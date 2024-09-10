package com.hisistant.auth.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class TimeSales {
    @Id
    private Long id;
    private LocalDateTime date;
    private int hour_0_count;
    private int hour_0_amount;
    private int hour_1_count;
    private int hour_1_amount;
    private int hour_2_count;
    private int hour_2_amount;
    private int hour_3_count;
    private int hour_3_amount;
    private int hour_4_count;
    private int hour_4_amount;
    private int hour_5_count;
    private int hour_5_amount;
    private int hour_6_count;
    private int hour_6_amount;
    private int hour_7_count;
    private int hour_7_amount;
    private int hour_8_count;
    private int hour_8_amount;
    private int hour_9_count;
    private int hour_9_amount;
    private int hour_10_count;
    private int hour_10_amount;
    private int hour_11_count;
    private int hour_11_amount;
    private int hour_12_count;
    private int hour_12_amount;

    private int hour_13_count;
    private int hour_13_amount;
    private int hour_14_count;
    private int hour_14_amount;
    private int hour_15_count;
    private int hour_15_amount;
    private int hour_16_count;
    private int hour_16_amount;
    private int hour_17_count;
    private int hour_17_amount;
    private int hour_18_count;
    private int hour_18_amount;
    private int hour_19_count;
    private int hour_19_amount;
    private int hour_20_count;
    private int hour_20_amount;
    private int hour_21_count;
    private int hour_21_amount;
    private int hour_22_count;
    private int hour_22_amount;
    private int hour_23_count;
    private int hour_23_amount;
    @Column(name = "user_id")
    private Long userId;
}
