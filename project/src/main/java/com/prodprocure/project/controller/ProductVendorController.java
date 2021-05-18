package com.prodprocure.project.controller;

import java.util.Optional;

import com.prodprocure.project.entity.ProductVendor;
import com.prodprocure.project.service.ProductVendorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class ProductVendorController {

    @Autowired
    ProductVendorService prodVendorService;

    // Create Product Vendor details
    @PostMapping("/prodvendor/add")
    public ProductVendor addProdVendor(@RequestBody ProductVendor prodVendor) {
        return prodVendorService.createProdVendor(prodVendor);
    }

    // Get all Product Vendor details
    @GetMapping("/prodvendor/getall")
    public Iterable<ProductVendor> getProdVendors() {
        return prodVendorService.getAllProdVendor();
    }

    // Get Product Vendor details by ID
    @GetMapping("/prodvendor/getById/{id}")
    public Optional<ProductVendor> getProdVendorsById(@PathVariable Integer id) {
        return prodVendorService.getProdVendorById(id);
    }

    // Get Product Vendor details by Vendor name
    @GetMapping("/prodvendor/getByvendorname/{name}")
    public Iterable<ProductVendor> getProdVendorByVendorName(@PathVariable String name) {
        return prodVendorService.getProdVendorByVendorName(name);
    }

    // Get Product Vendor details by Manufacturer Name
    @GetMapping("/prodvendor/getBymanufacturername/{manufacturerName}")
    public Iterable<ProductVendor> getProdVendorByManufacturerName(@PathVariable String manufacturerName) {
        return prodVendorService.getProdVendorByManufacturerName(manufacturerName);
    }

    // Get Product Vendor details by Product Name
    @GetMapping("/prodvendor/getByproductname/{productName}")
    public Iterable<ProductVendor> getProdVendorByProductName(@PathVariable String productName) {
        return prodVendorService.getProdVendorByProductName(productName);
    }

    // Get Product Vendor details by Manufacturer and Product names
    @GetMapping("/prodvendor/getbymanuandprodname/{name1}/{name2}")
    public Iterable<ProductVendor> getProdVendorByManufacturerandProductName(@PathVariable String name1, @PathVariable String name2) {
       return prodVendorService.getProdVendorByManufacturerProductName(name1, name2);
    }

    // Get Product Vendor details by any Name
    @GetMapping("/prodvendor/getByname/{name1}/{name2}/{name3}")
    public Iterable<ProductVendor> getProdVendorByVendorManufacturerProductName(@PathVariable String name1,
            @PathVariable String name2, @PathVariable String name3) {
        return prodVendorService.getProdVendorByVendorManufacturerProductName(name1, name2, name3);
    }

    //Update Product Vendor details
    @PatchMapping("/prodvendor/update/{id}")
    public ProductVendor updateProdVendor(@PathVariable Integer id, @RequestBody ProductVendor prodVendor) {
       return prodVendorService.updateProdVendor(id, prodVendor);
    }

    //Delete Product Vendor details
    @DeleteMapping("/prodvendor/deletebyId/{id}")
    public String deleteProdVendor(@PathVariable Integer id) {
        return prodVendorService.deleteProdVendor(id);
    }


    //Create Wishlist
    @PostMapping("/prodvendor/createwishlist/{id}")
    public String createWishlist(@PathVariable Integer id) {
       return prodVendorService.createWishlist(id);
    }

    // Get all Wishlist products
    @GetMapping("/prodvendor/getwishlist")
    public Iterable<ProductVendor> getWishlistedItems() {
       return prodVendorService.getWishlistedItems();
    }

    //Remove product from Wishlist
    @PatchMapping("/prodvendor/removewishlist/{id}")
    public String removeProductFromWishlist(@PathVariable Integer id) {
       return prodVendorService.removeWishlistProduct(id);
    }

    //Place order
    @PostMapping("/prodvendor/placeorder/{id}/{address}")
    public String createOrder(@PathVariable Integer id, @PathVariable String address) {
       return prodVendorService.orderproduct(id,address);
    }

}
