package com.example.demo.service.impl;

import com.example.demo.entity.CuaHang;
import com.example.demo.repositories.CuaHangRepository;
import com.example.demo.service.ICuaHang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuaHangService implements ICuaHang {

    @Autowired
    private CuaHangRepository repository;

    @Override
    public List<CuaHang> findAll() {
        return repository.findAll();
    }
}
