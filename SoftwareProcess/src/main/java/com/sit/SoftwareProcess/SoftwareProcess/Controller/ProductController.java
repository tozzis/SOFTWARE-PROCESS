package com.sit.SoftwareProcess.SoftwareProcess.Controller;

import java.util.List;

import javax.validation.Valid;

import com.sit.SoftwareProcess.SoftwareProcess.Model.Product;
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
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProuct() {
        List<Product> product = productService.getAllProduct();
        return new ResponseEntity<List<Product>>(product, HttpStatus.OK);
    }

    @GetMapping("/product/{product_id}")
    public ResponseEntity<Product> getProductById(@Valid @PathVariable Long product_id) {
        Product product = productService.getProductById(product_id);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

}