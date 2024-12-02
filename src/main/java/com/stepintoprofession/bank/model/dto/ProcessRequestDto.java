package com.stepintoprofession.bank.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcessRequestDto {
    @NotNull
    private Integer requestId;
    @NotNull
    private Boolean approve;
}
