package com.stepintoprofession.bank.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;
import lombok.NonNull;

import java.util.Date;

@Data
@Entity
@Table(name="requests")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JoinColumn(name="user_id")
    @ManyToOne
    @NotNull
    private User user;
    @JoinColumn(name="product_id")
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
