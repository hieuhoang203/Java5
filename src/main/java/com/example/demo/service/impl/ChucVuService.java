package com.example.demo.service.impl;

import com.example.demo.entity.ChucVu;
import com.example.demo.repositories.ChucVuRepository;
import com.example.demo.service.IChucVu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChucVuService implements IChucVu {

    @Autowired
    private ChucVuRepository repository;

    @Override
    public List<ChucVu> findAll() {
        return repository.findAll();
    }
}
