package com.stepintoprofession.bank.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "requests")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JoinColumn(name = "account_id")
    @ManyToOne
    @NotNull
    private Account account;
    @JoinColumn(name = "product_id")
    @ManyToOne
    @NotNull
    private Product product;
    @Enumerated(EnumType.STRING)
    @NotNull
    private RequestStatus status;
    @NotNull
    @PastOrPresent
    private Date createDate;
    private Date closeDate;
    @NotNull
    @Min(1)
    private Integer sum;
}


