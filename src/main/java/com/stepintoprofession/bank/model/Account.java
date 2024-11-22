package com.stepintoprofession.bank.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name="accounts")
public class Account {
    @Id
    @GeneratedValue
    private int id;
    @JoinColumn(name="user_id")
    @ManyToOne
    private User user;
    private int balance;
    private Date createDate;
    private Date closeDate;
    @Enumerated(EnumType.STRING)
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


