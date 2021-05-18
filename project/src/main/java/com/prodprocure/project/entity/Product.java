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
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productNum;
    
    private int manufacturerId;
    private String manufacturerName;
    private int productID;
    private String productName;
    private BigDecimal unitPrice;
}
