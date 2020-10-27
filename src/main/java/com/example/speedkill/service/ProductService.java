package com.example.speedkill.service;

import com.example.speedkill.model.AyProduct;

import java.util.Collection;
import java.util.List;

public interface ProductService {
    List<AyProduct> findAll();
    Collection<AyProduct> findAllCache();
    AyProduct killProduct(Integer productId, Integer userId);
}
