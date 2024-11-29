package com.stepintoprofession.bank.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.lang.NonNull;

@Entity
@Data
@Table(name="properties")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    private String name;
    @NotNull
    @Min(0)
    private Integer price;
    @JoinColumn(name="user_id")
    @ManyToOne
    @NotNull
    private User user;
}

/*
Собственность
1 Id
2 Название
3 Стоимость



 */
