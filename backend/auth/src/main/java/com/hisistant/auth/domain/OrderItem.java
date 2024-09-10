package com.hisistant.auth.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
    @Id @GeneratedValue
    private int id;
    @Column(name="menu_id")
    private int menuId;
    @Column(name="order_id")
    private int orderId;
    private int qty;
}
