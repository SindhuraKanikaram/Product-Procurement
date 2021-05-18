package com.prodprocure.project.Test;

import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;

import com.prodprocure.project.entity.Product;
import com.prodprocure.project.entity.ProductVendor;
import com.prodprocure.project.entity.Vendor;
import com.prodprocure.project.repository.ProductRepository;
import com.prodprocure.project.repository.ProductVendorRepository;
import com.prodprocure.project.repository.VendorRepository;
import com.prodprocure.project.service.ProductVendorService;

import org.h2.command.dml.MergeUsing.When;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@RunWith(MockitoJUnitRunner.class)
@DataJpaTest
public class ProductVendorTest {
    

    private static int id;
    private static String vendorName;
    private static double vDiscount;
    private static String address;
    private static long contactNum;
    private static String contactPerson;

    @Mock
    private ProductVendorRepository productVendorRepository;

    // @Mock
    // private Vendor vendor;

    @Mock
    private VendorRepository vendorRepository;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductVendorService productVendorService;

    @Before
    public void beforeCall() {
        ProductVendor prodVendor = new ProductVendor();
        prodVendor.setVendorId(1);

        Vendor vendor = new Vendor();
        vendor.setVendorId(1);
        vendor.setVendorName("reliance");
        vendor.setvDiscount(12);
        vendor.setAddress("bangalore");
        vendor.setContactNum(12345);
        vendor.setContactPerson("person1");
        vendorRepository.save(vendor);
        when(prodVendor.getVendorId()).thenReturn(1);
        when(vendorRepository.findById(prodVendor.getVendorId()).get()).thenReturn(vendor);

        Product product = new Product();
        product.setProductID(2);
        product.setProductName("laptop");
        product.setManufacturerName("apple");
        product.setUnitPrice(BigDecimal.valueOf(1000));
        productRepository.save(product);
        when(prodVendor.getProductNum()).thenReturn(2);
        when(productRepository.findById(prodVendor.getProductNum()).get()).thenReturn(product);
    }

    @Test
    public void testProductVendor() {

        // Mockito.when((vendorRepository.findById(id)).get()).thenReturn(Arrays.asList(new Vendor(1, "reliance", 12, 12345, "Name1"));

        ProductVendor productVendor = new ProductVendor();
        productVendor.setQuantity(100);
        productVendor.setCustOrdQty(20);
        productVendor.setVendorId(1);
        productVendor.setProductNum(2);
        productVendorService.createProdVendor(productVendor);

        ProductVendor productVendorTest = productVendorRepository.findById(productVendor.getTransactionId()).get();
        Assertions.assertEquals(8800, productVendorTest.getDiscountPrice());
    }
}
