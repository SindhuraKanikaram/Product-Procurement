package com.prodprocure.project.repository;

import com.prodprocure.project.entity.ProductVendor;

import org.springframework.data.repository.CrudRepository;

public interface ProductVendorRepository extends CrudRepository<ProductVendor, Integer>{

    public Iterable<ProductVendor> findByvendorName(String vendorName);  

    public Iterable<ProductVendor> findBymanufacturerName(String manufacturerName);   
    
    public Iterable<ProductVendor> findByproductName(String productName);

    public Iterable<ProductVendor> findBymanufacturerNameAndProductName(String manufacturerName, String productName);

    public Iterable<ProductVendor> findByvendorNameOrManufacturerNameOrProductName(String vendorName, 
                                                                                String manufacturerName, String productName);        
    
    public Iterable<ProductVendor> findByWishlist(boolean wishlist);     
    
}
