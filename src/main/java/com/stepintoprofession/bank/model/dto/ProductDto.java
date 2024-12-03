package com.stepintoprofession.bank.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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



