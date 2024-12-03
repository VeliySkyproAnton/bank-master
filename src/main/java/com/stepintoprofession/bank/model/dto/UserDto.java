package com.stepintoprofession.bank.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
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
    @NotNull
    private List<PropertyDto> propertyList;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String phone;
}
