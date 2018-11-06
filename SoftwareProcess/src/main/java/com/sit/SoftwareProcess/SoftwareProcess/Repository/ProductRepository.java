package com.sit.SoftwareProcess.SoftwareProcess.Repository;

import com.sit.SoftwareProcess.SoftwareProcess.Model.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}