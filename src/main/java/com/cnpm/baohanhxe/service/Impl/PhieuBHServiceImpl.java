package com.cnpm.baohanhxe.service.Impl;

import com.cnpm.baohanhxe.entity.PhieuBaoHanh;
import com.cnpm.baohanhxe.repository.PhieuBaoHanhRepository;
import com.cnpm.baohanhxe.service.PhieuBHService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class PhieuBHServiceImpl implements PhieuBHService {
    @Autowired
    private PhieuBaoHanhRepository phieuBaoHanhRepository;

    @Override
    public List<PhieuBaoHanh> findAll() {
        return phieuBaoHanhRepository.findAll();
    }

    @Override
    public List<PhieuBaoHanh> findAll(Sort sort) {
        return phieuBaoHanhRepository.findAll(sort);
    }

    @Override
    public List<PhieuBaoHanh> findAllById(Iterable<Long> longs) {
        return phieuBaoHanhRepository.findAllById(longs);
    }

    @Override
    public <S extends PhieuBaoHanh> List<S> saveAll(Iterable<S> entities) {
        return phieuBaoHanhRepository.saveAll(entities);
    }

    @Override
    public List<PhieuBaoHanh> findByMaXeBH_MaXe(Long maxe) {
        return phieuBaoHanhRepository.findByMaXeBH_MaXe(maxe);
    }

    @Override
    public void flush() {
        phieuBaoHanhRepository.flush();
    }

    @Override
    public <S extends PhieuBaoHanh> S saveAndFlush(S entity) {
        return phieuBaoHanhRepository.saveAndFlush(entity);
    }

    @Override
    public <S extends PhieuBaoHanh> List<S> saveAllAndFlush(Iterable<S> entities) {
        return phieuBaoHanhRepository.saveAllAndFlush(entities);
    }

    @Override
    @Deprecated
    public void deleteInBatch(Iterable<PhieuBaoHanh> entities) {
        phieuBaoHanhRepository.deleteInBatch(entities);
    }

    @Override
    public void deleteAllInBatch(Iterable<PhieuBaoHanh> entities) {
        phieuBaoHanhRepository.deleteAllInBatch(entities);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {
        phieuBaoHanhRepository.deleteAllByIdInBatch(longs);
    }

    @Override
    public void deleteAllInBatch() {
        phieuBaoHanhRepository.deleteAllInBatch();
    }

    @Override
    @Deprecated
    public PhieuBaoHanh getOne(Long aLong) {
        return phieuBaoHanhRepository.getOne(aLong);
    }

    @Override
    @Deprecated
    public PhieuBaoHanh getById(Long aLong) {
        return phieuBaoHanhRepository.getById(aLong);
    }

    @Override
    public PhieuBaoHanh getReferenceById(Long aLong) {
        return phieuBaoHanhRepository.getReferenceById(aLong);
    }

    @Override
    public <S extends PhieuBaoHanh> List<S> findAll(Example<S> example) {
        return phieuBaoHanhRepository.findAll(example);
    }

    @Override
    public <S extends PhieuBaoHanh> List<S> findAll(Example<S> example, Sort sort) {
        return phieuBaoHanhRepository.findAll(example, sort);
    }

    @Override
    public Page<PhieuBaoHanh> findAll(Pageable pageable) {
        return phieuBaoHanhRepository.findAll(pageable);
    }

    @Override
    public Page<PhieuBaoHanh> findByMaNVBH_TenContainingOrStatus(String ten,Short status, Pageable pageable) {
        return phieuBaoHanhRepository.findByMaNVBH_TenContainingOrStatus(ten,status, pageable);
    }

    @Override
    public Page<PhieuBaoHanh> findByMaNVBH_TenContaining(String ten, Pageable pageable) {
        return phieuBaoHanhRepository.findByMaNVBH_TenContaining(ten, pageable);
    }

    @Override
    public Page<PhieuBaoHanh> findByStatus(Short status, Pageable pageable) {
        return phieuBaoHanhRepository.findByStatus(status, pageable);
    }

    @Override
    public <S extends PhieuBaoHanh> S save(S entity) {
        return phieuBaoHanhRepository.save(entity);
    }

    @Override
    public Optional<PhieuBaoHanh> findById(Long aLong) {
        return phieuBaoHanhRepository.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return phieuBaoHanhRepository.existsById(aLong);
    }

    @Override
    public long count() {
        return phieuBaoHanhRepository.count();
    }

    @Override
    public void deleteById(Long aLong) {
        phieuBaoHanhRepository.deleteById(aLong);
    }

    @Override
    public void delete(PhieuBaoHanh entity) {
        phieuBaoHanhRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        phieuBaoHanhRepository.deleteAllById(longs);
    }

    @Override
    public void deleteAll(Iterable<? extends PhieuBaoHanh> entities) {
        phieuBaoHanhRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        phieuBaoHanhRepository.deleteAll();
    }

    @Override
    public <S extends PhieuBaoHanh> Optional<S> findOne(Example<S> example) {
        return phieuBaoHanhRepository.findOne(example);
    }

    @Override
    public <S extends PhieuBaoHanh> Page<S> findAll(Example<S> example, Pageable pageable) {
        return phieuBaoHanhRepository.findAll(example, pageable);
    }

    @Override
    public <S extends PhieuBaoHanh> long count(Example<S> example) {
        return phieuBaoHanhRepository.count(example);
    }

    @Override
    public <S extends PhieuBaoHanh> boolean exists(Example<S> example) {
        return phieuBaoHanhRepository.exists(example);
    }

    @Override
    public <S extends PhieuBaoHanh, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return phieuBaoHanhRepository.findBy(example, queryFunction);
    }
}
