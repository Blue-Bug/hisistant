package com.hisistant.auth.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id @GeneratedValue
    private int id;
    private int payment_amount;
    private LocalDateTime order_date;
    private Long user_id;
}
