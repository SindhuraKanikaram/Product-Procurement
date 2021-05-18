package com.prodprocure.project.controller;

import java.util.Optional;

import com.prodprocure.project.entity.Product;
import com.prodprocure.project.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

   //  Create Products
    @PostMapping("/product/add")
    public Product addProduct(@RequestBody Product product) {
       return productService.createProduct(product);
    }

   //  Get all Products
    @GetMapping("/product/getall")
    public Iterable<Product> getAllProducts() {
       return productService.getProducts();        
    }
    
   //  Get Product by ID
    @GetMapping("/product/getById/{id}")
    public Optional<Product> getProductById(@PathVariable Integer id) {
       return productService.getProductById(id);
    }

   //  Get Product by Manufacturer name
    @GetMapping("/product/getBymanufacturername/{manufacturerName}")
    public  Iterable<Product> getProductByManufacturerName(@PathVariable String manufacturerName) {
       return productService.getProductByManufacturerName(manufacturerName);
    }

   //  Get Product by Product name
    @GetMapping("/product/getByproductname/{productName}")
    public Iterable<Product> getProductByProductName(@PathVariable String productName) {
       return productService.getProductByProductName(productName);
    }

   //  Update Product details
    @PatchMapping("/product/update")
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

   //  Delete Product details
    @DeleteMapping("/product/delete/{productNum}")
    public String deleteProduct(@PathVariable Integer id) {
      return productService.deleteProduct(id);
    }
}
