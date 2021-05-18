package com.prodprocure.project.repository;

import com.prodprocure.project.entity.Vendor;

import org.springframework.data.repository.CrudRepository;

public interface VendorRepository extends CrudRepository<Vendor, Integer> {

    public Iterable<Vendor> findByvendorName(String vendorName);   
    
}
