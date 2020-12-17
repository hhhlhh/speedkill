package com.example.speedkill.repository;

import com.example.speedkill.model.AyProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<AyProduct, Integer> {

}
