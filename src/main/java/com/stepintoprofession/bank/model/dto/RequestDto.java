package com.stepintoprofession.bank.model.dto;

import com.stepintoprofession.bank.model.entity.Product;
import com.stepintoprofession.bank.model.entity.RequestStatus;
import com.stepintoprofession.bank.model.entity.User;
import jakarta.persistence.*;
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
public class RequestDto {
    private Integer id;
    @NotNull
    private Integer accountId;
    @NotNull
    private Integer productId;
    @NotBlank
    private String status;
    @NotNull
    @PastOrPresent
    private Date createDate;
    private Date closeDate;
    @NotNull
    @Min(1)
    private Integer sum;
}


