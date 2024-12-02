package com.stepintoprofession.bank.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stepintoprofession.bank.model.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyDto {
    private Integer id;
    @NotBlank
    private String name;
    @NotNull
    @Min(0)
    private Integer price;
}
