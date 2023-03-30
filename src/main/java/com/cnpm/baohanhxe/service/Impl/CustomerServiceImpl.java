package com.cnpm.baohanhxe.service.Impl;

import com.cnpm.baohanhxe.entity.KhachHang;
import com.cnpm.baohanhxe.repository.CustomerRepository;
import com.cnpm.baohanhxe.service.CustomerService;
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
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Optional<KhachHang> findBySdt(String sdt) {
        return customerRepository.findBySdt(sdt);
    }

    @Override
    public Optional<KhachHang> findByCmnd(String cmnd) {
        return customerRepository.findByCmnd(cmnd);
    }

    @Override
    public Page<KhachHang> findByTenContaining(String ten, Pageable pageable) {
        return customerRepository.findByTenContaining(ten, pageable);
    }

    @Override
    public List<KhachHang> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public List<KhachHang> findAll(Sort sort) {
        return customerRepository.findAll(sort);
    }

    @Override
    public List<KhachHang> findAllById(Iterable<Long> longs) {
        return customerRepository.findAllById(longs);
    }

    @Override
    public <S extends KhachHang> List<S> saveAll(Iterable<S> entities) {
        return customerRepository.saveAll(entities);
    }

    @Override
    public void flush() {
        customerRepository.flush();
    }

    @Override
    public <S extends KhachHang> S saveAndFlush(S entity) {
        return customerRepository.saveAndFlush(entity);
    }

    @Override
    public <S extends KhachHang> List<S> saveAllAndFlush(Iterable<S> entities) {
        return customerRepository.saveAllAndFlush(entities);
    }

    @Override
    @Deprecated
    public void deleteInBatch(Iterable<KhachHang> entities) {
        customerRepository.deleteInBatch(entities);
    }

    @Override
    public void deleteAllInBatch(Iterable<KhachHang> entities) {
        customerRepository.deleteAllInBatch(entities);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {
        customerRepository.deleteAllByIdInBatch(longs);
    }

    @Override
    public void deleteAllInBatch() {
        customerRepository.deleteAllInBatch();
    }

    @Override
    @Deprecated
    public KhachHang getOne(Long aLong) {
        return customerRepository.getOne(aLong);
    }

    @Override
    @Deprecated
    public KhachHang getById(Long aLong) {
        return customerRepository.getById(aLong);
    }

    @Override
    public KhachHang getReferenceById(Long aLong) {
        return customerRepository.getReferenceById(aLong);
    }

    @Override
    public <S extends KhachHang> List<S> findAll(Example<S> example) {
        return customerRepository.findAll(example);
    }

    @Override
    public <S extends KhachHang> List<S> findAll(Example<S> example, Sort sort) {
        return customerRepository.findAll(example, sort);
    }

    @Override
    public Page<KhachHang> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public <S extends KhachHang> S save(S entity) {
        return customerRepository.save(entity);
    }

    @Override
    public Optional<KhachHang> findById(Long aLong) {
        return customerRepository.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return customerRepository.existsById(aLong);
    }

    @Override
    public long count() {
        return customerRepository.count();
    }

    @Override
    public void deleteById(Long aLong) {
        customerRepository.deleteById(aLong);
    }

    @Override
    public void delete(KhachHang entity) {
        customerRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        customerRepository.deleteAllById(longs);
    }

    @Override
    public void deleteAll(Iterable<? extends KhachHang> entities) {
        customerRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        customerRepository.deleteAll();
    }

    @Override
    public <S extends KhachHang> Optional<S> findOne(Example<S> example) {
        return customerRepository.findOne(example);
    }

    @Override
    public <S extends KhachHang> Page<S> findAll(Example<S> example, Pageable pageable) {
        return customerRepository.findAll(example, pageable);
    }

    @Override
    public <S extends KhachHang> long count(Example<S> example) {
        return customerRepository.count(example);
    }

    @Override
    public <S extends KhachHang> boolean exists(Example<S> example) {
        return customerRepository.exists(example);
    }

    @Override
    public <S extends KhachHang, R> R findBy(Example<S> example,
            Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return customerRepository.findBy(example, queryFunction);
    }
}
