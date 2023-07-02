package com.example.demo.service;

import com.example.demo.entity.NhanVien;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface INhanVien {

    List<NhanVien> findAll(Pageable pageable);

    void save(NhanVien nhanVien);

    void update(NhanVien nhanVien);

    void delete(UUID id);

    List<NhanVien> search(int min, int max, Pageable pageable);

    NhanVien findById(UUID id);

}
