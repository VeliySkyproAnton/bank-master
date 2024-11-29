package com.stepintoprofession.bank.model.dto;

import com.stepintoprofession.bank.model.entity.Account;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto {
    private Integer id;
    @NotNull
    @Min(1)
    private Integer sum;
    @NotNull
    @PastOrPresent
    private Date date;
    @NotNull
    private Integer fromAccountId;
    @NotNull
    private Integer toAccountId;
}



