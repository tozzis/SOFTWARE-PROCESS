package com.sit.SoftwareProcess.ProductImage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImageService {

    @Autowired
    private ProductImageRepository productImageRepository;

    public List<ProductImage> getAllProductImages() {
        return productImageRepository.findAll();
    }
    
    public ProductImage getProductImagesByProductImageId(Long product_image_Id){
        return productImageRepository.getOne(product_image_Id);
    }
}