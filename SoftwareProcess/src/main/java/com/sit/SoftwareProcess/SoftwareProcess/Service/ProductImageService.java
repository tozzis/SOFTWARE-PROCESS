package com.sit.SoftwareProcess.SoftwareProcess.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.sit.SoftwareProcess.SoftwareProcess.Model.Product;
import com.sit.SoftwareProcess.SoftwareProcess.Model.ProductImage;
import com.sit.SoftwareProcess.SoftwareProcess.Repository.ProductImageRepository;

@Service
public class ProductImageService {

    @Autowired
    private ProductImageRepository productImageRepository;

    public List<ProductImage> getAllProductImages() {
        return productImageRepository.findAll();
    }
    
    public ProductImage getProductImagesByProductImageId(Long product_image_id){
        return productImageRepository.getOne(product_image_id);
    }

    public List<ProductImage> getAllImageByProduct(Product product){
        return productImageRepository.getProductImageByProduct(product);
    }
}