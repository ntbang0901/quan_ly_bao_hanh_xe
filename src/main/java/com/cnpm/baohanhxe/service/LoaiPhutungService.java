package com.cnpm.baohanhxe.service;

import com.cnpm.baohanhxe.entity.LoaiPhuTung;
import com.cnpm.baohanhxe.entity.Role;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface LoaiPhutungService {


    List<LoaiPhuTung> findAll();

    List<LoaiPhuTung> findAll(Sort sort);

    List<LoaiPhuTung> findAllById(Iterable<Long> longs);

    <S extends LoaiPhuTung> List<S> saveAll(Iterable<S> entities);

    void flush();

    <S extends LoaiPhuTung> S saveAndFlush(S entity);

    <S extends LoaiPhuTung> List<S> saveAllAndFlush(Iterable<S> entities);

    @Deprecated
    void deleteInBatch(Iterable<LoaiPhuTung> entities);

    void deleteAllInBatch(Iterable<LoaiPhuTung> entities);

    void deleteAllByIdInBatch(Iterable<Long> longs);

    void deleteAllInBatch();

    @Deprecated
    LoaiPhuTung getOne(Long aLong);

    @Deprecated
    LoaiPhuTung getById(Long aLong);

    LoaiPhuTung getReferenceById(Long aLong);

    <S extends LoaiPhuTung> List<S> findAll(Example<S> example);

    <S extends LoaiPhuTung> List<S> findAll(Example<S> example, Sort sort);

    Page<LoaiPhuTung> findAll(Pageable pageable);

    <S extends LoaiPhuTung> S save(S entity);

    Optional<LoaiPhuTung> findById(Long aLong);

    boolean existsById(Long aLong);

    long count();

    void deleteById(Long aLong);

    void delete(LoaiPhuTung entity);

    void deleteAllById(Iterable<? extends Long> longs);

    void deleteAll(Iterable<? extends LoaiPhuTung> entities);

    void deleteAll();

    Page<LoaiPhuTung> findByTenLoaiContaining(String loaiPhutung, Pageable pageable);

    <S extends LoaiPhuTung> Optional<S> findOne(Example<S> example);

    <S extends LoaiPhuTung> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends LoaiPhuTung> long count(Example<S> example);

    <S extends LoaiPhuTung> boolean exists(Example<S> example);

    <S extends LoaiPhuTung, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
}
