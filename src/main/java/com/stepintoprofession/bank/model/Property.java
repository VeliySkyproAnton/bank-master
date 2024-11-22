package com.stepintoprofession.bank.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="properties")
public class Property {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int price;
    @JoinColumn(name="user_id")
    @ManyToOne
    private User user;
}

/*
Собственность
1 Id
2 Название
3 Стоимость



 */
