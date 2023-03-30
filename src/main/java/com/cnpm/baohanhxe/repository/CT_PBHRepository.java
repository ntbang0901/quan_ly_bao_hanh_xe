package com.cnpm.baohanhxe.repository;

import com.cnpm.baohanhxe.entity.CT_PBHId;
import com.cnpm.baohanhxe.entity.CT_PhieuBH;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface CT_PBHRepository extends CrudRepository<CT_PhieuBH, CT_PBHId> {
    Optional<CT_PhieuBH> findByPhieuBaoHanh_MaPBH(CT_PBHId maPBH);
    List<CT_PhieuBH> findByPhieuBaoHanh_MaPBH(long maPBH);
}
