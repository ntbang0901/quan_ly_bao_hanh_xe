package com.cnpm.baohanhxe.repository;

import com.cnpm.baohanhxe.entity.NhanVien;
import com.cnpm.baohanhxe.entity.PhieuBaoHanh;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PhieuBaoHanhRepository extends JpaRepository<PhieuBaoHanh,Long> {
    Page<PhieuBaoHanh> findByMaNVBH_TenContainingOrStatus(String ten,Short status, Pageable pageable);
    Page<PhieuBaoHanh> findByMaNVBH_TenContaining(String ten, Pageable pageable);
    Page<PhieuBaoHanh> findByStatus(Short status,Pageable pageable);
    List<PhieuBaoHanh> findByMaXeBH_MaXe(Long maxe);


}
