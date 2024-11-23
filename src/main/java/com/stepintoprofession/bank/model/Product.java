package com.stepintoprofession.bank.model;

import jakarta.persistence.*;
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
    private int id;
    private String name;
    @Enumerated(EnumType.STRING)
    private ProductCategory category;

    public static final Product CREATE_ACCOUNT = new Product(0, "Открыть счет", ProductCategory.SERVICE);
}

/*

Продукт
1 Id
2 Название
3 Категория (Кредит вклад услуга)

*/

