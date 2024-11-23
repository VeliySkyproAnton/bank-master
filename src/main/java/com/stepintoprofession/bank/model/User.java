package com.stepintoprofession.bank.model;

import jakarta.persistence.*;
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
    private int id;
    @NonNull
    private String surname;
    @NonNull
    private String name;
    private String patronymic;
    @NonNull
    private Integer passportSeries;
    @NonNull
    private Integer passportNumber;
    @NonNull
    private String passportRegistration;
    @NonNull
    private String residence;
    @NonNull
    private Date birthDate;
    @NonNull
    private Boolean criminal;
    @NonNull
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
