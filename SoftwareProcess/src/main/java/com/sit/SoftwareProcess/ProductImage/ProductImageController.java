package com.sit.SoftwareProcess.ProductImage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductImageController {

    @Autowired
    private ProductImageService productImageService;

    @CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
    @GetMapping("/productimages")
    public ResponseEntity<List<ProductImage>> getAllProuctImage() {
        List<ProductImage> productImages = productImageService.getAllProductImages();
        return new ResponseEntity<List<ProductImage>>(productImages, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
    @GetMapping("/productimage/{product_image_Id}")
    public ResponseEntity<ProductImage> getProductImageById(@PathVariable Long product_image_Id) {
        ProductImage productImages = productImageService.getProductImagesByProductImageId(product_image_Id);
        return new ResponseEntity<ProductImage>(productImages, HttpStatus.OK);
    }

}