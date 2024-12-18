package com.stepintoprofession.bank.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepositDto {
    @NotNull
    private Integer accountId;
    @NotNull
    @Min(1)
    private Integer sum;
}
