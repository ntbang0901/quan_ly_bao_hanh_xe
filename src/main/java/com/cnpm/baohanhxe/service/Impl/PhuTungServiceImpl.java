package com.cnpm.baohanhxe.service.Impl;

import com.cnpm.baohanhxe.entity.LoaiPhuTung;
import com.cnpm.baohanhxe.entity.PhuTung;
import com.cnpm.baohanhxe.repository.PhuTungRepository;
import com.cnpm.baohanhxe.service.PhuTungService;
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
public class PhuTungServiceImpl implements PhuTungService {

    @Autowired
    PhuTungRepository phuTungRepository;

    @Override
    public List<PhuTung> findAll() {
        return phuTungRepository.findAll();
    }

    @Override
    public List<PhuTung> findAll(Sort sort) {
        return phuTungRepository.findAll(sort);
    }

    @Override
    public List<PhuTung> findAllById(Iterable<Long> longs) {
        return phuTungRepository.findAllById(longs);
    }

    @Override
    public <S extends PhuTung> List<S> saveAll(Iterable<S> entities) {
        return phuTungRepository.saveAll(entities);
    }

    @Override
    public void flush() {
        phuTungRepository.flush();
    }

    @Override
    public <S extends PhuTung> S saveAndFlush(S entity) {
        return phuTungRepository.saveAndFlush(entity);
    }

    @Override
    public <S extends PhuTung> List<S> saveAllAndFlush(Iterable<S> entities) {
        return phuTungRepository.saveAllAndFlush(entities);
    }

    @Override
    @Deprecated
    public void deleteInBatch(Iterable<PhuTung> entities) {
        phuTungRepository.deleteInBatch(entities);
    }

    @Override
    public void deleteAllInBatch(Iterable<PhuTung> entities) {
        phuTungRepository.deleteAllInBatch(entities);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {
        phuTungRepository.deleteAllByIdInBatch(longs);
    }

    @Override
    public void deleteAllInBatch() {
        phuTungRepository.deleteAllInBatch();
    }

    @Override
    @Deprecated
    public PhuTung getOne(Long aLong) {
        return phuTungRepository.getOne(aLong);
    }

    @Override
    @Deprecated
    public PhuTung getById(Long aLong) {
        return phuTungRepository.getById(aLong);
    }

    @Override
    public PhuTung getReferenceById(Long aLong) {
        return phuTungRepository.getReferenceById(aLong);
    }

    @Override
    public <S extends PhuTung> List<S> findAll(Example<S> example) {
        return phuTungRepository.findAll(example);
    }

    @Override
    public <S extends PhuTung> List<S> findAll(Example<S> example, Sort sort) {
        return phuTungRepository.findAll(example, sort);
    }

    @Override
    public Page<PhuTung> findAll(Pageable pageable) {
        return phuTungRepository.findAll(pageable);
    }

    @Override
    public <S extends PhuTung> S save(S entity) {
        return phuTungRepository.save(entity);
    }

    @Override
    public Optional<PhuTung> findById(Long aLong) {
        return phuTungRepository.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return phuTungRepository.existsById(aLong);
    }

    @Override
    public long count() {
        return phuTungRepository.count();
    }

    @Override
    public void deleteById(Long aLong) {
        phuTungRepository.deleteById(aLong);
    }

    @Override
    public void delete(PhuTung entity) {
        phuTungRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        phuTungRepository.deleteAllById(longs);
    }

    @Override
    public void deleteAll(Iterable<? extends PhuTung> entities) {
        phuTungRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        phuTungRepository.deleteAll();
    }

    @Override
    public <S extends PhuTung> Optional<S> findOne(Example<S> example) {
        return phuTungRepository.findOne(example);
    }

    @Override
    public <S extends PhuTung> Page<S> findAll(Example<S> example, Pageable pageable) {
        return phuTungRepository.findAll(example, pageable);
    }

    @Override
    public <S extends PhuTung> long count(Example<S> example) {
        return phuTungRepository.count(example);
    }

    @Override
    public <S extends PhuTung> boolean exists(Example<S> example) {
        return phuTungRepository.exists(example);
    }

    @Override
    public <S extends PhuTung, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return phuTungRepository.findBy(example, queryFunction);
    }

    @Override
    public Page<PhuTung> findByMaLoaiPhutung(LoaiPhuTung maLoaiPhutung, Pageable pageable) {
        // TODO Auto-generated method stub
        return phuTungRepository.findByMaLoaiPhutung(maLoaiPhutung, pageable);
    }
    @Override
    public Page<PhuTung> findByTenPhutungContaining(String phutung, Pageable pageable) {
        return phuTungRepository.findByTenPhutungContaining(phutung, pageable);
    }
    @Override
    public Page<PhuTung> findByTenPhutungContainingOrMaLoaiPhutung(String ten,LoaiPhuTung maLoaiPhutung, Pageable pageable) {
        // TODO Auto-generated method stub
        return phuTungRepository.findByTenPhutungContainingOrMaLoaiPhutung(ten, maLoaiPhutung, pageable);
    }

    
}
