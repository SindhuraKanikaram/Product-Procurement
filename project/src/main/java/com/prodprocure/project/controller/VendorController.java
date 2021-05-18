package com.prodprocure.project.controller;

import java.util.Optional;

import com.prodprocure.project.entity.Vendor;
import com.prodprocure.project.service.VendorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendorController {

    @Autowired
    VendorService vendorService;

    /*Create Vendors*/ 
    @PostMapping("/vendor/add")
    public Vendor addVendors(@RequestBody Vendor vendor) {
        return vendorService.createVendors(vendor);
    }

    // Get all Vendors
    @GetMapping("/vendor/getall")
    public Iterable<Vendor> getVendors() {
        return vendorService.getAllVendors();
    }   
    
    // Get Vendor by ID
    @GetMapping("/vendor/getById/{id}")
    public Optional<Vendor> getVendorById(@PathVariable Integer id) {
        return vendorService.getVendorById(id); 
    }

    // Get Vendors by Vendor name
    @GetMapping("/vendor/getByVendorName/{vendorName}")
    public Iterable<Vendor> getVendorByVendorName(@PathVariable String vendorName) {
       return vendorService.getVendoyByName(vendorName);
    }

    // Update Vendors 
    @PatchMapping("/vendor/update/{vendorId}")
    public Vendor updateVendor(@RequestBody Vendor vendor, @PathVariable Integer vendorId) {
       return vendorService.updateVendors(vendor, vendorId);   
    }

    // Delete Vendors 
    @DeleteMapping("/vendor/delete/{id}")
    public String deleteVendor(@PathVariable Integer id) {
       return vendorService.deleteVendors(id);
    }
}
