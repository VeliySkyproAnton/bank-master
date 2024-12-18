package com.stepintoprofession.bank.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Min(1)
    private Integer sum;
    @NotNull
    @PastOrPresent
    private Date date;
    @JoinColumn(name = "from_account_id")
    @ManyToOne
    private Account fromAccount;
    @JoinColumn(name = "to_account_id")
    @ManyToOne
    private Account toAccount;
}



