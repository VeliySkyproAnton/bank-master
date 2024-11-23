package com.stepintoprofession.bank.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.lang.NonNull;

@Entity
@Data
@Table(name="properties")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    private String name;
    @NonNull
    private Integer price;
    @JoinColumn(name="user_id")
    @ManyToOne
    @JsonIgnore
    private User user;
}

/*
Собственность
1 Id
2 Название
3 Стоимость



 */
