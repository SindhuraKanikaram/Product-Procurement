package com.prodprocure.project.Test;

import java.sql.Date;
import java.time.LocalDate;

import com.prodprocure.project.entity.Orders;
import com.prodprocure.project.repository.OrderRepository;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.IterableUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class OrdersTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void ordersTest() {
        Orders orders1 = new Orders();
        orders1.setVendorName("bajaj");
        orders1.setManufacturerName("haier");
        orders1.setProductName("fridge");
        orders1.setDeliveredAddress("hyd");
        orders1.setCustOrdQty(2);
        orders1.setOrderDate(Date.valueOf(LocalDate.now()));
        orderRepository.save(orders1);

        Orders orders2 = new Orders();
        orders2.setVendorName("bajaj");
        orders2.setManufacturerName("lg");
        orders2.setProductName("tv");
        orders2.setDeliveredAddress("hyd");
        orders2.setCustOrdQty(15);
        orders2.setOrderDate(Date.valueOf(LocalDate.now()));
        orderRepository.save(orders2);

        Orders orders3 = new Orders();
        orders3.setVendorName("bajaj");
        orders3.setManufacturerName("lg");
        orders3.setProductName("fridge");
        orders3.setDeliveredAddress("chennai");
        orders3.setCustOrdQty(10);
        orders3.setOrderDate(Date.valueOf("2021-05-05"));
        orderRepository.save(orders3);

        Iterable<Orders> ordersTest =  orderRepository.findByorderDate(Date.valueOf(LocalDate.now()));
        int count = IterableUtil.sizeOf(ordersTest);
        Assertions.assertThat(count).isEqualTo(2);
        
    }
    
}
