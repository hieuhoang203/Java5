package com.example.demo.repositories;

import com.example.demo.entity.NhanVien;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, UUID> {

    @Query(value = "select nv from NhanVien nv where " +
            "(?1 is null or datediff(year, nv.ngaySinh, getdate()) >= ?1) AND " +
            "(?2 is null or datediff(year, nv.ngaySinh, getdate()) <= ?2)", nativeQuery = true)
    List<NhanVien> search(int min, int max, Pageable pageable);

}
