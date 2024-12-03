package com.stepintoprofession.bank.model.dto;

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
public class RequestDto {
    private Integer id;
    @NotNull
    private Integer accountId;
    @NotNull
    private Integer productId;
    private String status;
    @PastOrPresent
    private Date createDate;
    private Date closeDate;
    @NotNull
    @Min(1)
    private Integer sum;
}


