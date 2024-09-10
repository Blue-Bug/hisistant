package com.hisistant.auth.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuCategory {
    @Id
    public Long id;
    @ManyToOne
    @JoinColumn(name="user_id")
    public User user;
    public String name;
}
