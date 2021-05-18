package com.prodprocure.project.repository;

import com.prodprocure.project.entity.Product;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    
    public Iterable<Product> findBymanufacturerName(String manufacturerName);   
    
    public Iterable<Product> findByproductName(String productName);
}
