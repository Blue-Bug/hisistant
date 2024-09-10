package com.hisistant.auth.domain;

import jakarta.persistence.*;

@Entity
public class MenuCategory {
    @Id
    public Long id;
    @ManyToOne
    @JoinColumn(name="user_id")
    public User user;
    public String name;
}
