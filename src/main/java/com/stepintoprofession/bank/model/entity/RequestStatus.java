package com.stepintoprofession.bank.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RequestStatus {
    REJECTED("Rejected"),
    CLOSED("Closed"),
    IN_PROGRESS("In progress"),
    OPEN("Open");

    private final String title;
}
