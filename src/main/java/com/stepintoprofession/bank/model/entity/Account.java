package com.stepintoprofession.bank.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name="accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JoinColumn(name="user_id")
    @ManyToOne
    @NotNull
    private User user;
    @NotNull
    @Min(0)
    private Integer balance;
    @NotNull
    @PastOrPresent
    private Date createDate;
    private Date closeDate;
    @Enumerated(EnumType.STRING)
    @NotNull
    private AccountStatus status;
}
/*


Счет
1 Id
2 Клиент
3 Сумма
4 Дата создания
5 Дата закрытия
6 Статус закрыт заморожен открыт

*/


