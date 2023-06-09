package com.cnpm.baohanhxe.service;

import com.cnpm.baohanhxe.entity.NhanVien;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface StaffService {

    Page<NhanVien> findByTenContaining(String ten, Pageable pageable);
    Optional<NhanVien> findByCmnd(String cmnd);

    List<NhanVien> findAll();

    List<NhanVien> findAll(Sort sort);

    List<NhanVien> findAllById(Iterable<Long> longs);

    <S extends NhanVien> List<S> saveAll(Iterable<S> entities);

    void flush();

    <S extends NhanVien> S saveAndFlush(S entity);

    <S extends NhanVien> List<S> saveAllAndFlush(Iterable<S> entities);

    @Deprecated
    void deleteInBatch(Iterable<NhanVien> entities);

    void deleteAllInBatch(Iterable<NhanVien> entities);

    void deleteAllByIdInBatch(Iterable<Long> longs);

    void deleteAllInBatch();

    @Deprecated
    NhanVien getOne(Long aLong);

    @Deprecated
    NhanVien getById(Long aLong);

    NhanVien getReferenceById(Long aLong);

    <S extends NhanVien> List<S> findAll(Example<S> example);

    <S extends NhanVien> List<S> findAll(Example<S> example, Sort sort);

    Page<NhanVien> findAll(Pageable pageable);

    <S extends NhanVien> S save(S entity);

    Optional<NhanVien> findById(Long aLong);

    boolean existsById(Long aLong);

    long count();

    void deleteById(Long aLong);

    void delete(NhanVien entity);

    void deleteAllById(Iterable<? extends Long> longs);

    void deleteAll(Iterable<? extends NhanVien> entities);

    void deleteAll();

    <S extends NhanVien> Optional<S> findOne(Example<S> example);

    <S extends NhanVien> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends NhanVien> long count(Example<S> example);

    <S extends NhanVien> boolean exists(Example<S> example);

    <S extends NhanVien, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
}
