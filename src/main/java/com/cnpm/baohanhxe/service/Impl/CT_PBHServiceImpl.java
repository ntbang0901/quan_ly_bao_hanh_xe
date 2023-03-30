package com.cnpm.baohanhxe.service.Impl;

import com.cnpm.baohanhxe.entity.CT_PBHId;
import com.cnpm.baohanhxe.entity.CT_PhieuBH;
import com.cnpm.baohanhxe.entity.PhieuBaoHanh;
import com.cnpm.baohanhxe.entity.PhuTung;
import com.cnpm.baohanhxe.repository.CT_PBHRepository;
import com.cnpm.baohanhxe.service.CT_PBHService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CT_PBHServiceImpl implements CT_PBHService {
    @Autowired
    private CT_PBHRepository ct_pbhRepository;

    @Override
    public <S extends CT_PhieuBH> S save(S entity) {
        return ct_pbhRepository.save(entity);
    }

    @Override
    public <S extends CT_PhieuBH> Iterable<S> saveAll(Iterable<S> entities) {
        return ct_pbhRepository.saveAll(entities);
    }

    @Override
    public Optional<CT_PhieuBH> findById(CT_PBHId ct_pbhId) {
        return ct_pbhRepository.findById(ct_pbhId);
    }
    public void saveAttribute(PhieuBaoHanh pbh, PhuTung phutung, Long soluong) {
        CT_PhieuBH attr = new CT_PhieuBH(pbh, phutung, soluong);
        ct_pbhRepository.save(attr);
    }
    @Override
    public boolean existsById(CT_PBHId ct_pbhId) {
        return ct_pbhRepository.existsById(ct_pbhId);
    }

    @Override
    public Iterable<CT_PhieuBH> findAll() {
        return ct_pbhRepository.findAll();
    }

    @Override
    public Iterable<CT_PhieuBH> findAllById(Iterable<CT_PBHId> ct_pbhIds) {
        return ct_pbhRepository.findAllById(ct_pbhIds);
    }

    @Override
    public long count() {
        return ct_pbhRepository.count();
    }

    @Override
    public void deleteById(CT_PBHId ct_pbhId) {
        ct_pbhRepository.deleteById(ct_pbhId);
    }

    @Override
    public void delete(CT_PhieuBH entity) {
        ct_pbhRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends CT_PBHId> ct_pbhIds) {
        ct_pbhRepository.deleteAllById(ct_pbhIds);
    }

    @Override
    public void deleteAll(Iterable<? extends CT_PhieuBH> entities) {
        ct_pbhRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        ct_pbhRepository.deleteAll();
    }

    @Override
    public Optional<CT_PhieuBH> findByPhieuBaoHanh_MaPBH(CT_PBHId maPBH) {
        // TODO Auto-generated method stub
        return ct_pbhRepository.findByPhieuBaoHanh_MaPBH(maPBH);
    }

    @Override
    public List<CT_PhieuBH> findByPhieuBaoHanh_MaPBH(long maPBH) {
        // TODO Auto-generated method stub
        return ct_pbhRepository.findByPhieuBaoHanh_MaPBH(maPBH);
    }
}
