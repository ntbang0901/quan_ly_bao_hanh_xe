package com.cnpm.baohanhxe.service;

import com.cnpm.baohanhxe.entity.LoaiPhuTung;
import com.cnpm.baohanhxe.entity.PhuTung;
import com.cnpm.baohanhxe.entity.Role;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface PhuTungService {

    List<PhuTung> findAll();

    List<PhuTung> findAll(Sort sort);

    List<PhuTung> findAllById(Iterable<Long> longs);

    <S extends PhuTung> List<S> saveAll(Iterable<S> entities);

    void flush();

    <S extends PhuTung> S saveAndFlush(S entity);

    <S extends PhuTung> List<S> saveAllAndFlush(Iterable<S> entities);

    @Deprecated
    void deleteInBatch(Iterable<PhuTung> entities);

    void deleteAllInBatch(Iterable<PhuTung> entities);

    void deleteAllByIdInBatch(Iterable<Long> longs);

    void deleteAllInBatch();

    @Deprecated
    PhuTung getOne(Long aLong);

    @Deprecated
    PhuTung getById(Long aLong);

    PhuTung getReferenceById(Long aLong);

    <S extends PhuTung> List<S> findAll(Example<S> example);

    <S extends PhuTung> List<S> findAll(Example<S> example, Sort sort);

    Page<PhuTung> findAll(Pageable pageable);

    <S extends PhuTung> S save(S entity);

    Optional<PhuTung> findById(Long aLong);

    boolean existsById(Long aLong);

    long count();

    void deleteById(Long aLong);

    void delete(PhuTung entity);

    void deleteAllById(Iterable<? extends Long> longs);

    void deleteAll(Iterable<? extends PhuTung> entities);

    void deleteAll();

    Page<PhuTung> findByMaLoaiPhutung(LoaiPhuTung maLoaiPhutung, Pageable pageable);

    Page<PhuTung> findByTenPhutungContaining(String phutung, Pageable pageable);

    Page<PhuTung> findByTenPhutungContainingOrMaLoaiPhutung(String ten, LoaiPhuTung maLoaiPhutung, Pageable pageable);

    <S extends PhuTung> Optional<S> findOne(Example<S> example);

    <S extends PhuTung> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends PhuTung> long count(Example<S> example);

    <S extends PhuTung> boolean exists(Example<S> example);

    <S extends PhuTung, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
}
