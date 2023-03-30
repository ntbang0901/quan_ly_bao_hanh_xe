package com.cnpm.baohanhxe.service;

import com.cnpm.baohanhxe.entity.NhanVien;
import com.cnpm.baohanhxe.entity.PhieuBaoHanh;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface PhieuBHService {
    List<PhieuBaoHanh> findAll();

    List<PhieuBaoHanh> findAll(Sort sort);

    List<PhieuBaoHanh> findAllById(Iterable<Long> longs);

    <S extends PhieuBaoHanh> List<S> saveAll(Iterable<S> entities);

    List<PhieuBaoHanh> findByMaXeBH_MaXe(Long maxe);

    void flush();

    <S extends PhieuBaoHanh> S saveAndFlush(S entity);

    <S extends PhieuBaoHanh> List<S> saveAllAndFlush(Iterable<S> entities);

    @Deprecated
    void deleteInBatch(Iterable<PhieuBaoHanh> entities);

    void deleteAllInBatch(Iterable<PhieuBaoHanh> entities);

    void deleteAllByIdInBatch(Iterable<Long> longs);

    void deleteAllInBatch();

    @Deprecated
    PhieuBaoHanh getOne(Long aLong);

    @Deprecated
    PhieuBaoHanh getById(Long aLong);

    PhieuBaoHanh getReferenceById(Long aLong);

    <S extends PhieuBaoHanh> List<S> findAll(Example<S> example);

    <S extends PhieuBaoHanh> List<S> findAll(Example<S> example, Sort sort);

    Page<PhieuBaoHanh> findAll(Pageable pageable);

    Page<PhieuBaoHanh> findByMaNVBH_TenContainingOrStatus(String ten,Short status, Pageable pageable);

    Page<PhieuBaoHanh> findByMaNVBH_TenContaining(String ten, Pageable pageable);

    Page<PhieuBaoHanh> findByStatus(Short status, Pageable pageable);

    <S extends PhieuBaoHanh> S save(S entity);

    Optional<PhieuBaoHanh> findById(Long aLong);

    boolean existsById(Long aLong);

    long count();

    void deleteById(Long aLong);

    void delete(PhieuBaoHanh entity);

    void deleteAllById(Iterable<? extends Long> longs);

    void deleteAll(Iterable<? extends PhieuBaoHanh> entities);

    void deleteAll();



    <S extends PhieuBaoHanh> Optional<S> findOne(Example<S> example);

    <S extends PhieuBaoHanh> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends PhieuBaoHanh> long count(Example<S> example);

    <S extends PhieuBaoHanh> boolean exists(Example<S> example);

    <S extends PhieuBaoHanh, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
}
