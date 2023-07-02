package com.example.demo.service;

import com.example.demo.entity.CuaHang;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICuaHang {

    List<CuaHang> findAll();

}
