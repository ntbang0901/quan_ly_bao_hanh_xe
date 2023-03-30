package com.cnpm.baohanhxe.repository;

import com.cnpm.baohanhxe.entity.NhanVien;
import com.cnpm.baohanhxe.entity.TaiKhoan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StaffRepository  extends JpaRepository<NhanVien,Long> {
    Page<NhanVien> findByTenContaining(String ten, Pageable pageable);
    Optional<NhanVien> findByCmnd(String cmnd);
}