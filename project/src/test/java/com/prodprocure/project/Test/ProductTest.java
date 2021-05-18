package com.prodprocure.project.Test;

import java.math.BigDecimal;

import com.prodprocure.project.entity.Product;
import com.prodprocure.project.repository.ProductRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class ProductTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void createProductTest() {
        Product product = new Product();
        product.setManufacturerName("one plus");
        product.setProductName("phone");
        product.setUnitPrice(BigDecimal.valueOf(10000));
        productRepository.save(product);

        Product productTest = productRepository.findById(product.getProductNum()).get();
        Assertions.assertThat(productTest.getManufacturerName()).isEqualTo("one plus");
        Assertions.assertThat(productTest.getProductName()).isNotEqualTo("Phone");
    }
    
}
