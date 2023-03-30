package com.cnpm.baohanhxe.service;

import com.cnpm.baohanhxe.entity.TaiKhoan;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface AccountService {

    Optional<TaiKhoan> findByUser_MaNV(Long maNV);

    Page<TaiKhoan> findByUsernameContaining(String username, Pageable pageable);

    List<TaiKhoan> findAll();

    List<TaiKhoan> findAll(Sort sort);

    List<TaiKhoan> findAllById(Iterable<Long> longs);

    <S extends TaiKhoan> List<S> saveAll(Iterable<S> entities);

    void flush();

    <S extends TaiKhoan> S saveAndFlush(S entity);

    <S extends TaiKhoan> List<S> saveAllAndFlush(Iterable<S> entities);

    @Deprecated
    void deleteInBatch(Iterable<TaiKhoan> entities);

    void deleteAllInBatch(Iterable<TaiKhoan> entities);

    void deleteAllByIdInBatch(Iterable<Long> longs);

    void deleteAllInBatch();

    @Deprecated
    TaiKhoan getOne(Long aLong);

    @Deprecated
    TaiKhoan getById(Long aLong);

    TaiKhoan getReferenceById(Long aLong);

    <S extends TaiKhoan> List<S> findAll(Example<S> example);

    <S extends TaiKhoan> List<S> findAll(Example<S> example, Sort sort);

    Page<TaiKhoan> findAll(Pageable pageable);

    TaiKhoan getUserByUsername(String username);

    Optional<TaiKhoan> findByUsername(String username);

    TaiKhoan save(TaiKhoan taiKhoan);

    Optional<TaiKhoan> findById(Long aLong);

    boolean existsById(Long aLong);

    long count();

    void deleteById(Long aLong);

    void delete(TaiKhoan entity);

    void deleteAllById(Iterable<? extends Long> longs);

    void deleteAll(Iterable<? extends TaiKhoan> entities);

    void deleteAll();

    <S extends TaiKhoan> Optional<S> findOne(Example<S> example);

    <S extends TaiKhoan> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends TaiKhoan> long count(Example<S> example);

    <S extends TaiKhoan> boolean exists(Example<S> example);

    <S extends TaiKhoan, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
}
