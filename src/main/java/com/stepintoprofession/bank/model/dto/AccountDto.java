package com.stepintoprofession.bank.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    private Integer id;
    @NotNull
    private Integer userId;
    @NotNull
    @Min(0)
    private Integer balance;
    @NotNull
    @PastOrPresent
    private Date createDate;
    private Date closeDate;
    @NotBlank
    private String status;
}



