package com.cnpm.baohanhxe.repository;

import com.cnpm.baohanhxe.entity.KhachHang;
import com.cnpm.baohanhxe.entity.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<KhachHang,Long> {
    Page<KhachHang> findByTenContaining(String ten, Pageable pageable);
    Optional<KhachHang> findBySdt(String sdt);
    Optional<KhachHang> findByCmnd(String cmnd);

    
}