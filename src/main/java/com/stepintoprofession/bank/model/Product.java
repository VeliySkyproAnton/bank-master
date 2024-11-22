package com.stepintoprofession.bank.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="products")
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Enumerated(EnumType.STRING)
    private ProductCategory category;

    public Product(String name, ProductCategory category) {
        this.name = name;
        this.category = category;
    }
}

/*

Продукт
1 Id
2 Название
3 Категория (Кредит вклад услуга)

*/

