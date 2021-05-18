package com.prodprocure.project.service;

import java.util.Optional;

import com.prodprocure.project.entity.Vendor;
import com.prodprocure.project.repository.VendorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendorService {

    @Autowired
    VendorRepository vendorRepository;

    public Vendor createVendors(Vendor vendor){
        vendorRepository.save(vendor);
        return vendor;
    }

    public Iterable<Vendor> getAllVendors(){
       return vendorRepository.findAll();
    }

    public Optional<Vendor> getVendorById(Integer id) {
       return vendorRepository.findById(id);
    }

    public Iterable<Vendor> getVendoyByName(String vendorName) {
       return vendorRepository.findByvendorName(vendorName);
    }

    public Vendor updateVendors(Vendor vendor, Integer vendorId){
        vendor.setVendorId(vendorId);
        vendorRepository.save(vendor);
        return vendor;
    }

    public String deleteVendors(Integer id){
        vendorRepository.deleteById(id);
        return ("Vendor record with id: " + id + " is deleted successfully ");
    }
    
}
