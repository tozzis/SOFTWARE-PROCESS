package com.sit.SoftwareProcess.Product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProuct() {
        List<Product> product = productService.getAllProduct();
        return new ResponseEntity<List<Product>>(product, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
    @GetMapping("/product/{product_id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long product_id) {
        Product product = productService.getProductById(product_id);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

}