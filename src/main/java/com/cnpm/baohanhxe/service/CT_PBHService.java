package com.cnpm.baohanhxe.service;

import com.cnpm.baohanhxe.entity.CT_PBHId;
import com.cnpm.baohanhxe.entity.CT_PhieuBH;

import java.util.List;
import java.util.Optional;

public interface CT_PBHService {
    <S extends CT_PhieuBH> S save(S entity);

    <S extends CT_PhieuBH> Iterable<S> saveAll(Iterable<S> entities);

    Optional<CT_PhieuBH> findById(CT_PBHId ct_pbhId);
    Optional<CT_PhieuBH> findByPhieuBaoHanh_MaPBH(CT_PBHId maPBH);
    List<CT_PhieuBH> findByPhieuBaoHanh_MaPBH(long maPBH);

    boolean existsById(CT_PBHId ct_pbhId);

    Iterable<CT_PhieuBH> findAll();

    Iterable<CT_PhieuBH> findAllById(Iterable<CT_PBHId> ct_pbhIds);

    long count();

    void deleteById(CT_PBHId ct_pbhId);

    void delete(CT_PhieuBH entity);

    void deleteAllById(Iterable<? extends CT_PBHId> ct_pbhIds);

    void deleteAll(Iterable<? extends CT_PhieuBH> entities);

    void deleteAll();
}
