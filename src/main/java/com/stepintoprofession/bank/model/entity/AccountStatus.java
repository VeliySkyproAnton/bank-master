package com.stepintoprofession.bank.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AccountStatus {
    OPEN("Open"),
    FROZEN("Frozen"),
    CLOSED("Closed");

    private final String title;
}
