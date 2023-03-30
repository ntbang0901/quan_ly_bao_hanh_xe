package com.cnpm.baohanhxe.repository;

import com.cnpm.baohanhxe.entity.NhanVien;
import com.cnpm.baohanhxe.entity.Xe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XeRepository extends JpaRepository<Xe,Long> {
    Page<Xe> findByTenXeContaining(String tenXe, Pageable pageable);
}
