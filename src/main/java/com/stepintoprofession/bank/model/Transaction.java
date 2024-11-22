package com.stepintoprofession.bank.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name="transactions")
public class Transaction {
    @Id
    @GeneratedValue
    private int id;
    private int sum;
    private Date date;
    @JoinColumn(name="from_account_id")
    @ManyToOne
    private Account fromAccount;
    @JoinColumn(name="to_account_id")
    @ManyToOne
    private Account toAccount;
}

/*


Транзакция
1 Id
2 Сумма
3 Дата
4 Счет отправителя
5 Счет получателя
 */

