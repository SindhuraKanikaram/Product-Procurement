package com.prodprocure.project.service;

import java.sql.Date;
import java.util.Optional;

import com.prodprocure.project.entity.Orders;
import com.prodprocure.project.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public Iterable<Orders> getOrders() {
       return orderRepository.findAll();
    }

    public Optional<Orders> getOrdersById(Integer id) {
       return orderRepository.findById(id);
    }

    public Iterable<Orders> getOrdersByOrderdate(Date orderDate) {
       return orderRepository.findByorderDate(orderDate);
    }
    
}
