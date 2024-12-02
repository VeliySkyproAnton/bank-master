package com.stepintoprofession.bank.model.dto;

import com.stepintoprofession.bank.model.entity.ProductCategory;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Integer id;
    @NotBlank
    private String name;
    @NotBlank
    private String category;
    private Integer minSum;
    private Integer maxSum;
    private Float interestRate;
    private Long durationInSeconds;
}



