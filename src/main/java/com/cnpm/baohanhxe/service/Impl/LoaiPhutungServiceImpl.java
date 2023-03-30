package com.cnpm.baohanhxe.service.Impl;

import com.cnpm.baohanhxe.entity.LoaiPhuTung;
import com.cnpm.baohanhxe.repository.LoaiPhutungRepository;
import com.cnpm.baohanhxe.service.LoaiPhutungService;
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
public class LoaiPhutungServiceImpl implements LoaiPhutungService {

    @Autowired
    LoaiPhutungRepository loaiPhutungRepository;

    @Override
    public List<LoaiPhuTung> findAll() {
        return loaiPhutungRepository.findAll();
        
    }

    @Override
    public List<LoaiPhuTung> findAll(Sort sort) {
        return loaiPhutungRepository.findAll(sort);
    }

    @Override
    public List<LoaiPhuTung> findAllById(Iterable<Long> longs) {
        return loaiPhutungRepository.findAllById(longs);
    }

    @Override
    public <S extends LoaiPhuTung> List<S> saveAll(Iterable<S> entities) {
        return loaiPhutungRepository.saveAll(entities);
    }

    @Override
    public void flush() {
        loaiPhutungRepository.flush();
    }

    @Override
    public <S extends LoaiPhuTung> S saveAndFlush(S entity) {
        return loaiPhutungRepository.saveAndFlush(entity);
    }

    @Override
    public <S extends LoaiPhuTung> List<S> saveAllAndFlush(Iterable<S> entities) {
        return loaiPhutungRepository.saveAllAndFlush(entities);
    }

    @Override
    @Deprecated
    public void deleteInBatch(Iterable<LoaiPhuTung> entities) {
        loaiPhutungRepository.deleteInBatch(entities);
    }

    @Override
    public void deleteAllInBatch(Iterable<LoaiPhuTung> entities) {
        loaiPhutungRepository.deleteAllInBatch(entities);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {
        loaiPhutungRepository.deleteAllByIdInBatch(longs);
    }

    @Override
    public void deleteAllInBatch() {
        loaiPhutungRepository.deleteAllInBatch();
    }

    @Override
    @Deprecated
    public LoaiPhuTung getOne(Long aLong) {
        return loaiPhutungRepository.getOne(aLong);
    }

    @Override
    @Deprecated
    public LoaiPhuTung getById(Long aLong) {
        return loaiPhutungRepository.getById(aLong);
    }

    @Override
    public LoaiPhuTung getReferenceById(Long aLong) {
        return loaiPhutungRepository.getReferenceById(aLong);
    }

    @Override
    public <S extends LoaiPhuTung> List<S> findAll(Example<S> example) {
        return loaiPhutungRepository.findAll(example);
    }

    @Override
    public <S extends LoaiPhuTung> List<S> findAll(Example<S> example, Sort sort) {
        return loaiPhutungRepository.findAll(example, sort);
    }

    @Override
    public Page<LoaiPhuTung> findAll(Pageable pageable) {
        return loaiPhutungRepository.findAll(pageable);
    }

    @Override
    public <S extends LoaiPhuTung> S save(S entity) {
        return loaiPhutungRepository.save(entity);
    }

    @Override
    public Optional<LoaiPhuTung> findById(Long aLong) {
        return loaiPhutungRepository.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return loaiPhutungRepository.existsById(aLong);
    }

    @Override
    public long count() {
        return loaiPhutungRepository.count();
    }

    @Override
    public void deleteById(Long aLong) {
        loaiPhutungRepository.deleteById(aLong);
    }

    @Override
    public void delete(LoaiPhuTung entity) {
        loaiPhutungRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        loaiPhutungRepository.deleteAllById(longs);
    }

    @Override
    public void deleteAll(Iterable<? extends LoaiPhuTung> entities) {
        loaiPhutungRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        loaiPhutungRepository.deleteAll();
    }

    @Override
    public Page<LoaiPhuTung> findByTenLoaiContaining(String loaiPhutung, Pageable pageable) {
        return loaiPhutungRepository.findByTenLoaiContaining(loaiPhutung, pageable);
    }

    @Override
    public <S extends LoaiPhuTung> Optional<S> findOne(Example<S> example) {
        return loaiPhutungRepository.findOne(example);
    }

    @Override
    public <S extends LoaiPhuTung> Page<S> findAll(Example<S> example, Pageable pageable) {
        return loaiPhutungRepository.findAll(example, pageable);
    }

    @Override
    public <S extends LoaiPhuTung> long count(Example<S> example) {
        return loaiPhutungRepository.count(example);
    }

    @Override
    public <S extends LoaiPhuTung> boolean exists(Example<S> example) {
        return loaiPhutungRepository.exists(example);
    }

    @Override
    public <S extends LoaiPhuTung, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return loaiPhutungRepository.findBy(example, queryFunction);
    }
}
