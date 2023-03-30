package com.cnpm.baohanhxe.repository;

import com.cnpm.baohanhxe.entity.LoaiXe;
import com.cnpm.baohanhxe.entity.TaiKhoan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoaiXeRepository extends JpaRepository<LoaiXe,Long> {
    Page<LoaiXe> findByTenLoaiContaining(String loaixe, Pageable pageable);
}
