package com.prodprocure.project.service;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

import com.prodprocure.project.entity.Orders;
import com.prodprocure.project.entity.ProductVendor;
import com.prodprocure.project.entity.Product;
import com.prodprocure.project.entity.Vendor;
import com.prodprocure.project.repository.OrderRepository;
import com.prodprocure.project.repository.ProductVendorRepository;
import com.prodprocure.project.repository.ProductRepository;
import com.prodprocure.project.repository.VendorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductVendorService {

    private ProductVendorRepository prodVendorRepository;
    private VendorRepository vendorRepository;
    private ProductRepository productRepository;
    private OrderRepository orderRepository;

    @Autowired
    public ProductVendorService(ProductVendorRepository prodVendorRepository, VendorRepository vendorRepository,
            ProductRepository productRepository, OrderRepository orderRepository) {
        this.prodVendorRepository = prodVendorRepository;
        this.vendorRepository = vendorRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    public ProductVendor createProdVendor(ProductVendor prodVendor) {

        // Set Vendor name and Vendor discount
        Vendor vendor = vendorRepository.findById(prodVendor.getVendorId()).get();
        prodVendor.setVendorName(vendor.getVendorName());
        prodVendor.setVDiscount(vendor.getvDiscount());

        // Set Manufacturer name,Product name and Unit Price
        Product product = productRepository.findById(prodVendor.getProductNum()).get();
        prodVendor.setManufacturerName(product.getManufacturerName());
        prodVendor.setProductName(product.getProductName());
        prodVendor.setUnitPrice(product.getUnitPrice());

        // Set manufacturer Discount
        if (prodVendor.getCustOrdQty() > 0 && prodVendor.getCustOrdQty() <= 5) {
            prodVendor.setMDiscount(2);
        } else if (prodVendor.getCustOrdQty() > 6 && prodVendor.getCustOrdQty() <= 10) {
            prodVendor.setMDiscount(3);
        } else if (prodVendor.getCustOrdQty() > 10 && prodVendor.getCustOrdQty() <= 20) {
            prodVendor.setMDiscount(4);
        } else {
            prodVendor.setMDiscount(5);
        }

        // Set Total price
        BigDecimal totPrice = prodVendor.getUnitPrice().multiply(new BigDecimal(prodVendor.getCustOrdQty()));
        prodVendor.setTotPrice(totPrice);

        // Set Total Price After discount
        double discount = (1 - (prodVendor.getMDiscount() / 100)) * (1 - (prodVendor.getVDiscount() / 100));
        BigDecimal totPricAftDiscount = totPrice.multiply(BigDecimal.valueOf(discount));
        prodVendor.setTotPricAftDiscount(totPricAftDiscount);

        // Set Discount Price
        prodVendor.setDiscountPrice(prodVendor.getTotPrice().subtract(prodVendor.getTotPricAftDiscount()));

        // Save the product to DB only if Customer entered quality is less than or equal
        // to Total quantity
        if (prodVendor.getQuantity() >= prodVendor.getCustOrdQty()) {
            prodVendorRepository.save(prodVendor);
        }
        return prodVendor;
    }

    public Iterable<ProductVendor> getAllProdVendor() {
        return prodVendorRepository.findAll();
    }

    public Optional<ProductVendor> getProdVendorById(Integer id) {
        return prodVendorRepository.findById(id);
    }

    public Iterable<ProductVendor> getProdVendorByVendorName(String vendorName) {
        return prodVendorRepository.findByvendorName(vendorName);
    }

    public Iterable<ProductVendor> getProdVendorByManufacturerName(String manufacturerName) {
        return prodVendorRepository.findBymanufacturerName(manufacturerName);
    }

    public Iterable<ProductVendor> getProdVendorByProductName(String productName) {
        return prodVendorRepository.findByproductName(productName);
    }

    public Iterable<ProductVendor> getProdVendorByManufacturerProductName(String manufacturerName, String productName) {
        return prodVendorRepository.findBymanufacturerNameAndProductName(manufacturerName, productName);
    }

    public Iterable<ProductVendor> getProdVendorByVendorManufacturerProductName(String name1, String name2,
            String name3) {
        return prodVendorRepository.findByvendorNameOrManufacturerNameOrProductName(name1, name2, name3);
    }

    // Update Product Vendor details
    public ProductVendor updateProdVendor(Integer id, ProductVendor prodVendor) {
        prodVendor.setTransactionId(id);
        return this.createProdVendor(prodVendor);
    }

    // Delete Product Vendor details
    public String deleteProdVendor(Integer id) {
        prodVendorRepository.deleteById(id);
        return ("Product Vendor id: " + id + " is deleted");
    }

    // Create Wishlist
    public String createWishlist(Integer id) {
        ProductVendor prodVendor = prodVendorRepository.findById(id).get();
        prodVendor.setWishlist(true);
        prodVendorRepository.save(prodVendor);
        return ("Product Vendor id: " + id + " is added to Wishlist");
    }

    // Get Wishlist
    public Iterable<ProductVendor> getWishlistedItems() {
        return prodVendorRepository.findByWishlist(true);
    }

    // Remove product from Wishlist
    public String removeWishlistProduct(Integer id) {

        ProductVendor prodVendor = prodVendorRepository.findById(id).get();
        prodVendor.setWishlist(false);
        prodVendorRepository.save(prodVendor);          
    
        return ("Product id: " + id + " removed from the wishlist");      
    }

    // Order product
    public String orderproduct(Integer id, String address) {
        ProductVendor prodVendor = prodVendorRepository.findById(id).get();
        prodVendor.setOrdered(true);
        Orders order = new Orders();
        order.setTransactionId(id);
        order.setVendorId(prodVendor.getVendorId());
        order.setVendorName(prodVendor.getVendorName());
        order.setProductNum(prodVendor.getProductNum());
        order.setManufacturerName(prodVendor.getManufacturerName());
        order.setProductName(prodVendor.getProductName());
        order.setCustOrdQty(prodVendor.getCustOrdQty());
        order.setOrderDate(Date.valueOf(LocalDate.now()));
        order.setDeliverDate(Date.valueOf(LocalDate.now().plusDays(10)));
        order.setTotPrice(prodVendor.getTotPricAftDiscount());
        order.setDeliveredAddress(address);
        orderRepository.save(order);
        return "Order placed successfully";
    }

}
