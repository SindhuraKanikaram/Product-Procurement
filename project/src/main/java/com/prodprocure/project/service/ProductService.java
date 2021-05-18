package com.prodprocure.project.service;

import java.util.Optional;

import com.prodprocure.project.entity.Product;
import com.prodprocure.project.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product createProduct(Product product) {
        productRepository.save(product);
        return product;
    }

    public Iterable<Product> getProducts() {
       return productRepository.findAll();
    }

    public Optional<Product> getProductById(Integer id){
       return productRepository.findById(id);
    }

    public Iterable<Product> getProductByManufacturerName(String manufacturerName) {
       return productRepository.findBymanufacturerName(manufacturerName);
    }

    public Iterable<Product> getProductByProductName(String productName) {
        return productRepository.findByproductName(productName);
     }

     public Product updateProduct(Product product) {
        // productRepository.save(product);
        // return product;
        return this.createProduct(product);
    }

    public String deleteProduct(Integer id) {
        productRepository.deleteById(id);
        return "Product record with id " + id + " is deleted";
    }
    
}
