package com.example.speedkill.service.impl;

import com.example.speedkill.model.AyUserKillProduct;
import com.example.speedkill.repository.AyUserKillProductRepository;
import com.example.speedkill.service.AyUserKillProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AyUserKillProductServiceImpl implements AyUserKillProductService {
    @Resource
    private AyUserKillProductRepository ayUserKillProductRepository;

    @Override
    public AyUserKillProduct save(AyUserKillProduct killProduct) {
        return ayUserKillProductRepository.save(killProduct);
    }
}
