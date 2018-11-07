package com.sit.SoftwareProcess.SoftwareProcess.Controller;

import java.util.List;

import javax.validation.Valid;

import com.sit.SoftwareProcess.SoftwareProcess.Model.Product;
import com.sit.SoftwareProcess.SoftwareProcess.Model.ProductImage;
import com.sit.SoftwareProcess.SoftwareProcess.Service.ProductImageService;
import com.sit.SoftwareProcess.SoftwareProcess.Service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://software-process.mybluemix.net", maxAge = 3600)
public class ProductImageController {

    @Autowired
    private ProductImageService productImageService;

    @Autowired
    private ProductService productService;

    @GetMapping("/product/image/{product_id}")
    public ResponseEntity<List<ProductImage>> getAllImageByProduct(@Valid @PathVariable Long product_id) {
        Product product = productService.getProductById(product_id);
        List<ProductImage> productImage = productImageService.getAllImageByProduct(product);
        return new ResponseEntity<List<ProductImage>>(productImage, HttpStatus.OK);
    }

    @GetMapping("/product/image/id/{product_image_id}")
    public ResponseEntity<ProductImage> getProductImageById(@Valid @PathVariable Long product_image_id) {
        ProductImage productImage = productImageService.getProductImagesByProductImageId(product_image_id);
        return new ResponseEntity<ProductImage>(productImage, HttpStatus.OK);
    }

}