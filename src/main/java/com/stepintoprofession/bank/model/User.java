package com.stepintoprofession.bank.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue
    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private int passportSeries;
    private int passportNumber;
    private String passportRegistration;
    private String residence;
    private Date birthDate;
    private boolean criminal;
    private int income;
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
