package com.cnpm.baohanhxe.repository;

import com.cnpm.baohanhxe.entity.LoaiPhuTung;

import com.cnpm.baohanhxe.entity.TaiKhoan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoaiPhutungRepository extends JpaRepository<LoaiPhuTung,Long> {
    Page<LoaiPhuTung> findByTenLoaiContaining(String loaiPhutung, Pageable pageable);
}
