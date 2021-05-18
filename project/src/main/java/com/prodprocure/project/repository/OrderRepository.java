package com.prodprocure.project.repository;

import java.sql.Date;

import com.prodprocure.project.entity.Orders;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Orders, Integer> {
    public Iterable<Orders> findByorderDate(Date orderDate);        
}
