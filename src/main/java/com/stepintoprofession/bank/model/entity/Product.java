package com.stepintoprofession.bank.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="products")
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    private Integer id;
    @NotBlank
    private String name;
    @Enumerated(EnumType.STRING)
    @NotNull
    private ProductCategory category;

    public static final Product CREATE_ACCOUNT = new Product(0, "Открыть счет", ProductCategory.SERVICE);
}

/*

Продукт
1 Id
2 Название
3 Категория (Кредит вклад услуга)

*/

