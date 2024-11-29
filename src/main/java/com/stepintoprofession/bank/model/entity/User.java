package com.stepintoprofession.bank.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="users")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    private String surname;
    @NotBlank
    private String name;
    @NotBlank
    private String patronymic;
    @NotNull
    private Integer passportSeries;
    @NotNull
    private Integer passportNumber;
    @NotBlank
    private String passportRegistration;
    @NotBlank
    private String residence;
    @NotNull
    @Past
    private Date birthDate;
    @NotNull
    private Boolean criminal;
    @NotNull
    private Integer income;
    @OneToMany(mappedBy = "user")
    private List<Property> propertyList;
/*    2 Ф
3 И
4 О
5 Серия паспорта
6 Номер паспорта
7 Место регистрации
8 Место проживания
9 Возраст
10 Судимость
11 Заработок
12 IdСобственность */

}
