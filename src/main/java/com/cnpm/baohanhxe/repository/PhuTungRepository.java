package com.cnpm.baohanhxe.repository;

import com.cnpm.baohanhxe.entity.LoaiPhuTung;
import com.cnpm.baohanhxe.entity.PhuTung;
import com.cnpm.baohanhxe.entity.TaiKhoan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhuTungRepository extends JpaRepository<PhuTung,Long> {
    Page<PhuTung> findByTenPhutungContainingOrMaLoaiPhutung(String ten,LoaiPhuTung maLoaiPhutung, Pageable pageable);
    Page<PhuTung> findByTenPhutungContaining(String phutung, Pageable pageable);
    Page<PhuTung> findByMaLoaiPhutung(LoaiPhuTung maLoaiPhutung, Pageable pageable);
}
