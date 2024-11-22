package com.stepintoprofession.bank.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name="requests")
public class Request {
    @Id
    @GeneratedValue
    private int id;
    @JoinColumn(name="user_id")
    @ManyToOne
    private User user;
    @JoinColumn(name="product_id")
    @ManyToOne
    private Product product;
    @Enumerated(EnumType.STRING)
    private RequestStatus status;
    private Date createDate;
    private Date closeDate;
}

/*


Заявка
1 Id
2 Клиент
3 Продукт
4 Статус на рассмотрении в исполнении отклонена закрыта
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!5 Список заявок созданных после закрытия данной заявки
6 Дата закрытия
7 Дата создания



 */
