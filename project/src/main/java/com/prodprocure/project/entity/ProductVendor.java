package com.prodprocure.project.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ProductVendor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int transactionId;

    private int vendorId;
    private String vendorName;
    private int productNum;
    private String manufacturerName;
    private String productName;
    private double quantity;
    private BigDecimal unitPrice;
    private int custOrdQty;
    private double mDiscount;
    private double vDiscount;
    private BigDecimal totPrice;
    private BigDecimal discountPrice;
    private BigDecimal totPricAftDiscount;
    private boolean wishlist;
    private boolean ordered;
}
