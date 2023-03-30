package com.cnpm.baohanhxe.service;

import com.cnpm.baohanhxe.entity.KhachHang;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface CustomerService {

    Optional<KhachHang> findBySdt(String sdt);
    Optional<KhachHang> findByCmnd(String cmnd);

    Page<KhachHang> findByTenContaining(String ten, Pageable pageable);

    List<KhachHang> findAll();

    List<KhachHang> findAll(Sort sort);

    List<KhachHang> findAllById(Iterable<Long> longs);

    <S extends KhachHang> List<S> saveAll(Iterable<S> entities);

    void flush();

    <S extends KhachHang> S saveAndFlush(S entity);

    <S extends KhachHang> List<S> saveAllAndFlush(Iterable<S> entities);

    @Deprecated
    void deleteInBatch(Iterable<KhachHang> entities);

    void deleteAllInBatch(Iterable<KhachHang> entities);

    void deleteAllByIdInBatch(Iterable<Long> longs);

    void deleteAllInBatch();

    @Deprecated
    KhachHang getOne(Long aLong);

    @Deprecated
    KhachHang getById(Long aLong);

    KhachHang getReferenceById(Long aLong);

    <S extends KhachHang> List<S> findAll(Example<S> example);

    <S extends KhachHang> List<S> findAll(Example<S> example, Sort sort);

    Page<KhachHang> findAll(Pageable pageable);

    <S extends KhachHang> S save(S entity);

    Optional<KhachHang> findById(Long aLong);

    boolean existsById(Long aLong);

    long count();

    void deleteById(Long aLong);

    void delete(KhachHang entity);

    void deleteAllById(Iterable<? extends Long> longs);

    void deleteAll(Iterable<? extends KhachHang> entities);

    void deleteAll();

    <S extends KhachHang> Optional<S> findOne(Example<S> example);

    <S extends KhachHang> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends KhachHang> long count(Example<S> example);

    <S extends KhachHang> boolean exists(Example<S> example);

    <S extends KhachHang, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
}
