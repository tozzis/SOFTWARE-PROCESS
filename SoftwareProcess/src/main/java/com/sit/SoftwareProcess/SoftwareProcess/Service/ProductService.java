package com.sit.SoftwareProcess.SoftwareProcess.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.sit.SoftwareProcess.SoftwareProcess.Model.Product;
import com.sit.SoftwareProcess.SoftwareProcess.Repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    public Product getProductById(long product_id) {
        return productRepository.getOne(product_id);
    }

}