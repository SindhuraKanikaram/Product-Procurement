package com.prodprocure.project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int vendorId;

    private String vendorName;
    private double vDiscount;
    private String address;
    private long contactNum;
    private String contactPerson;

    /* Getter and Setter for vDiscount*/
    public double getvDiscount() {
        return vDiscount;
    }

    public void setvDiscount(double vDiscount) {
        this.vDiscount = vDiscount;
    }
}
