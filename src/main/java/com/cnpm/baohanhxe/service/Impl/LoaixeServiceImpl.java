package com.cnpm.baohanhxe.service.Impl;

import com.cnpm.baohanhxe.entity.LoaiXe;
import com.cnpm.baohanhxe.repository.LoaiXeRepository;
import com.cnpm.baohanhxe.service.LoaixeService;
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
public class LoaixeServiceImpl implements LoaixeService {

    @Autowired
    LoaiXeRepository loaiXeRepository;

    @Override
    public List<LoaiXe> findAll() {
        return loaiXeRepository.findAll();
        
    }

    @Override
    public List<LoaiXe> findAll(Sort sort) {
        return loaiXeRepository.findAll(sort);
    }

    @Override
    public List<LoaiXe> findAllById(Iterable<Long> longs) {
        return loaiXeRepository.findAllById(longs);
    }

    @Override
    public <S extends LoaiXe> List<S> saveAll(Iterable<S> entities) {
        return loaiXeRepository.saveAll(entities);
    }

    @Override
    public void flush() {
        loaiXeRepository.flush();
    }

    @Override
    public <S extends LoaiXe> S saveAndFlush(S entity) {
        return loaiXeRepository.saveAndFlush(entity);
    }

    @Override
    public <S extends LoaiXe> List<S> saveAllAndFlush(Iterable<S> entities) {
        return loaiXeRepository.saveAllAndFlush(entities);
    }

    @Override
    @Deprecated
    public void deleteInBatch(Iterable<LoaiXe> entities) {
        loaiXeRepository.deleteInBatch(entities);
    }

    @Override
    public void deleteAllInBatch(Iterable<LoaiXe> entities) {
        loaiXeRepository.deleteAllInBatch(entities);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {
        loaiXeRepository.deleteAllByIdInBatch(longs);
    }

    @Override
    public void deleteAllInBatch() {
        loaiXeRepository.deleteAllInBatch();
    }

    @Override
    @Deprecated
    public LoaiXe getOne(Long aLong) {
        return loaiXeRepository.getOne(aLong);
    }

    @Override
    @Deprecated
    public LoaiXe getById(Long aLong) {
        return loaiXeRepository.getById(aLong);
    }

    @Override
    public LoaiXe getReferenceById(Long aLong) {
        return loaiXeRepository.getReferenceById(aLong);
    }

    @Override
    public <S extends LoaiXe> List<S> findAll(Example<S> example) {
        return loaiXeRepository.findAll(example);
    }

    @Override
    public <S extends LoaiXe> List<S> findAll(Example<S> example, Sort sort) {
        return loaiXeRepository.findAll(example, sort);
    }

    @Override
    public Page<LoaiXe> findAll(Pageable pageable) {
        return loaiXeRepository.findAll(pageable);
    }

    @Override
    public <S extends LoaiXe> S save(S entity) {
        return loaiXeRepository.save(entity);
    }

    @Override
    public Optional<LoaiXe> findById(Long aLong) {
        return loaiXeRepository.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return loaiXeRepository.existsById(aLong);
    }

    @Override
    public long count() {
        return loaiXeRepository.count();
    }

    @Override
    public void deleteById(Long aLong) {
        loaiXeRepository.deleteById(aLong);
    }

    @Override
    public void delete(LoaiXe entity) {
        loaiXeRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        loaiXeRepository.deleteAllById(longs);
    }

    @Override
    public void deleteAll(Iterable<? extends LoaiXe> entities) {
        loaiXeRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        loaiXeRepository.deleteAll();
    }

    @Override
    public Page<LoaiXe> findByTenLoaiContaining(String loaixe, Pageable pageable) {
        return loaiXeRepository.findByTenLoaiContaining(loaixe, pageable);
    }

    @Override
    public <S extends LoaiXe> Optional<S> findOne(Example<S> example) {
        return loaiXeRepository.findOne(example);
    }

    @Override
    public <S extends LoaiXe> Page<S> findAll(Example<S> example, Pageable pageable) {
        return loaiXeRepository.findAll(example, pageable);
    }

    @Override
    public <S extends LoaiXe> long count(Example<S> example) {
        return loaiXeRepository.count(example);
    }

    @Override
    public <S extends LoaiXe> boolean exists(Example<S> example) {
        return loaiXeRepository.exists(example);
    }

    @Override
    public <S extends LoaiXe, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return loaiXeRepository.findBy(example, queryFunction);
    }
}
