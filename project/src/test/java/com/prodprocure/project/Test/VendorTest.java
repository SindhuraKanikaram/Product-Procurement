package com.prodprocure.project.Test;

import com.prodprocure.project.entity.Vendor;
import com.prodprocure.project.repository.VendorRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class VendorTest {

    @Autowired
    private VendorRepository vendorRepository;


    @Test
    public void createVendorTest() {
        Vendor vendor = new Vendor();
        vendor.setVendorName("vendor1");
        vendor.setAddress("bangalore");
        vendor.setvDiscount(12.5);
        vendorRepository.save(vendor);

        Vendor vendortest = vendorRepository.findById(vendor.getVendorId()).get();
        Assertions.assertEquals("vendor1", vendortest.getVendorName());
        Assertions.assertNotEquals("Vendor1", vendortest.getVendorName(), "Case sensitive");
        assertThat(vendortest.getVendorName()).isEqualTo("vendor1");
        
        
    }
    
}
