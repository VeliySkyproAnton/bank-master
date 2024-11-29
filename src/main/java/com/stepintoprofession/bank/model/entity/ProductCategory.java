package com.stepintoprofession.bank.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProductCategory {
    CREDIT("Credit"),
    DEPOSIT("Deposit"),
    SERVICE("Service");

    private final String title;
}
