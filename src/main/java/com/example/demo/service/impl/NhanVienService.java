package com.example.demo.service.impl;

import com.example.demo.entity.NhanVien;
import com.example.demo.repositories.NhanVienRepository;
import com.example.demo.service.INhanVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NhanVienService implements INhanVien {

    @Autowired
    private NhanVienRepository repository;

    @Override
    public List<NhanVien> findAll(Pageable pageable) {
        return repository.findAll(pageable).stream().toList();
    }

    @Override
    public void save(NhanVien nhanVien) {
        this.repository.save(nhanVien);
    }

    @Override
    public void update(NhanVien nhanVien) {
        this.repository.save(nhanVien);
    }

    @Override
    public void delete(UUID id) {
        this.repository.deleteById(id);
    }

    @Override
    public List<NhanVien> search(int min, int max, Pageable pageable) {
        return this.repository.search(min, max, pageable);
    }

    @Override
    public NhanVien findById(UUID id) {
        return this.repository.findById(id).orElse(null);
    }
}
