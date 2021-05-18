package com.prodprocure.project.controller;

import java.sql.Date;
import java.util.Optional;

import com.prodprocure.project.entity.Orders;
import com.prodprocure.project.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    
    @Autowired
    OrderService orderService;

   //  Get all Orders
    @GetMapping("/order/getall")
    public Iterable<Orders> getAllOrders() {
       return orderService.getOrders();
    }

   //  Get Orders by ID
    @GetMapping("/order/getById/{id}")
    public Optional<Orders> getOrderById(@PathVariable Integer id){
       return orderService.getOrdersById(id);
    }

   //  Get Orders by Ordered Date
    @GetMapping("/order/getByorderdate/{date}")
    public Iterable<Orders> getOrdersByOrderdate(@PathVariable Date date) {
       return orderService.getOrdersByOrderdate(date);
    }
}
