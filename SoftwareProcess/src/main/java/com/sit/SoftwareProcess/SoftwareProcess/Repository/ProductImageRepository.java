package com.sit.SoftwareProcess.SoftwareProcess.Repository;

import java.util.List;

import com.sit.SoftwareProcess.SoftwareProcess.Model.Product;
import com.sit.SoftwareProcess.SoftwareProcess.Model.ProductImage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {
    public List<ProductImage> getProductImageByProduct(Product product);
}
