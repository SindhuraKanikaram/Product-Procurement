package com.prodprocure.project.entity;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    private int transactionId;
    private int vendorId;
    private String vendorName;
    private int productNum;
    private String manufacturerName;
    private String productName;
    private int custOrdQty;
    private Date orderDate;
    private Date deliverDate;
    private BigDecimal totPrice;
    private String deliveredAddress;

}
