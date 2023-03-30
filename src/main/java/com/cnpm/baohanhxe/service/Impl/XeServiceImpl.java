package com.cnpm.baohanhxe.service.Impl;

import com.cnpm.baohanhxe.entity.Xe;
import com.cnpm.baohanhxe.repository.XeRepository;
import com.cnpm.baohanhxe.service.XeService;
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
public class XeServiceImpl implements XeService {
    @Autowired
    private XeRepository xeRepository;


    @Override
    public Page<Xe> findByTenXeContaining(String tenXe, Pageable pageable) {
        return xeRepository.findByTenXeContaining(tenXe, pageable);
    }

    @Override
    public List<Xe> findAll() {
        return xeRepository.findAll();
    }

    @Override
    public List<Xe> findAll(Sort sort) {
        return xeRepository.findAll(sort);
    }

    @Override
    public List<Xe> findAllById(Iterable<Long> longs) {
        return xeRepository.findAllById(longs);
    }

    @Override
    public <S extends Xe> List<S> saveAll(Iterable<S> entities) {
        return xeRepository.saveAll(entities);
    }

    @Override
    public void flush() {
        xeRepository.flush();
    }

    @Override
    public <S extends Xe> S saveAndFlush(S entity) {
        return xeRepository.saveAndFlush(entity);
    }

    @Override
    public <S extends Xe> List<S> saveAllAndFlush(Iterable<S> entities) {
        return xeRepository.saveAllAndFlush(entities);
    }

    @Override
    @Deprecated
    public void deleteInBatch(Iterable<Xe> entities) {
        xeRepository.deleteInBatch(entities);
    }

    @Override
    public void deleteAllInBatch(Iterable<Xe> entities) {
        xeRepository.deleteAllInBatch(entities);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {
        xeRepository.deleteAllByIdInBatch(longs);
    }

    @Override
    public void deleteAllInBatch() {
        xeRepository.deleteAllInBatch();
    }

    @Override
    @Deprecated
    public Xe getOne(Long aLong) {
        return xeRepository.getOne(aLong);
    }

    @Override
    @Deprecated
    public Xe getById(Long aLong) {
        return xeRepository.getById(aLong);
    }

    @Override
    public Xe getReferenceById(Long aLong) {
        return xeRepository.getReferenceById(aLong);
    }

    @Override
    public <S extends Xe> List<S> findAll(Example<S> example) {
        return xeRepository.findAll(example);
    }

    @Override
    public <S extends Xe> List<S> findAll(Example<S> example, Sort sort) {
        return xeRepository.findAll(example, sort);
    }

    @Override
    public Page<Xe> findAll(Pageable pageable) {
        return xeRepository.findAll(pageable);
    }

    @Override
    public <S extends Xe> S save(S entity) {
        return xeRepository.save(entity);
    }

    @Override
    public Optional<Xe> findById(Long aLong) {
        return xeRepository.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return xeRepository.existsById(aLong);
    }

    @Override
    public long count() {
        return xeRepository.count();
    }

    @Override
    public void deleteById(Long aLong) {
        xeRepository.deleteById(aLong);
    }

    @Override
    public void delete(Xe entity) {
        xeRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        xeRepository.deleteAllById(longs);
    }

    @Override
    public void deleteAll(Iterable<? extends Xe> entities) {
        xeRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        xeRepository.deleteAll();
    }

    @Override
    public <S extends Xe> Optional<S> findOne(Example<S> example) {
        return xeRepository.findOne(example);
    }

    @Override
    public <S extends Xe> Page<S> findAll(Example<S> example, Pageable pageable) {
        return xeRepository.findAll(example, pageable);
    }

    @Override
    public <S extends Xe> long count(Example<S> example) {
        return xeRepository.count(example);
    }

    @Override
    public <S extends Xe> boolean exists(Example<S> example) {
        return xeRepository.exists(example);
    }

    @Override
    public <S extends Xe, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return xeRepository.findBy(example, queryFunction);
    }
}
