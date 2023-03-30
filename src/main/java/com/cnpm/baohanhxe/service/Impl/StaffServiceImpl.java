package com.cnpm.baohanhxe.service.Impl;

import com.cnpm.baohanhxe.entity.NhanVien;
import com.cnpm.baohanhxe.repository.StaffRepository;
import com.cnpm.baohanhxe.service.StaffService;
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
public class StaffServiceImpl implements StaffService {

   @Autowired
    private StaffRepository staffRepository;

    @Override
    public Page<NhanVien> findByTenContaining(String ten, Pageable pageable) {
        return staffRepository.findByTenContaining(ten, pageable);
    }

    @Override
    public List<NhanVien> findAll() {
        return staffRepository.findAll();
    }

    @Override
    public List<NhanVien> findAll(Sort sort) {
        return staffRepository.findAll(sort);
    }

    @Override
    public List<NhanVien> findAllById(Iterable<Long> longs) {
        return staffRepository.findAllById(longs);
    }

    @Override
    public <S extends NhanVien> List<S> saveAll(Iterable<S> entities) {
        return staffRepository.saveAll(entities);
    }

    @Override
    public void flush() {
        staffRepository.flush();
    }

    @Override
    public <S extends NhanVien> S saveAndFlush(S entity) {
        return staffRepository.saveAndFlush(entity);
    }

    @Override
    public <S extends NhanVien> List<S> saveAllAndFlush(Iterable<S> entities) {
        return staffRepository.saveAllAndFlush(entities);
    }

    @Override
    @Deprecated
    public void deleteInBatch(Iterable<NhanVien> entities) {
        staffRepository.deleteInBatch(entities);
    }

    @Override
    public void deleteAllInBatch(Iterable<NhanVien> entities) {
        staffRepository.deleteAllInBatch(entities);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {
        staffRepository.deleteAllByIdInBatch(longs);
    }

    @Override
    public void deleteAllInBatch() {
        staffRepository.deleteAllInBatch();
    }

    @Override
    @Deprecated
    public NhanVien getOne(Long aLong) {
        return staffRepository.getOne(aLong);
    }

    @Override
    @Deprecated
    public NhanVien getById(Long aLong) {
        return staffRepository.getById(aLong);
    }

    @Override
    public NhanVien getReferenceById(Long aLong) {
        return staffRepository.getReferenceById(aLong);
    }

    @Override
    public <S extends NhanVien> List<S> findAll(Example<S> example) {
        return staffRepository.findAll(example);
    }

    @Override
    public <S extends NhanVien> List<S> findAll(Example<S> example, Sort sort) {
        return staffRepository.findAll(example, sort);
    }

    @Override
    public Page<NhanVien> findAll(Pageable pageable) {
        return staffRepository.findAll(pageable);
    }

    @Override
    public <S extends NhanVien> S save(S entity) {
        return staffRepository.save(entity);
    }

    @Override
    public Optional<NhanVien> findById(Long aLong) {
        return staffRepository.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return staffRepository.existsById(aLong);
    }

    @Override
    public long count() {
        return staffRepository.count();
    }

    @Override
    public void deleteById(Long aLong) {
        staffRepository.deleteById(aLong);
    }

    @Override
    public void delete(NhanVien entity) {
        staffRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        staffRepository.deleteAllById(longs);
    }

    @Override
    public void deleteAll(Iterable<? extends NhanVien> entities) {
        staffRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        staffRepository.deleteAll();
    }

    @Override
    public <S extends NhanVien> Optional<S> findOne(Example<S> example) {
        return staffRepository.findOne(example);
    }

    @Override
    public <S extends NhanVien> Page<S> findAll(Example<S> example, Pageable pageable) {
        return staffRepository.findAll(example, pageable);
    }

    @Override
    public <S extends NhanVien> long count(Example<S> example) {
        return staffRepository.count(example);
    }

    @Override
    public <S extends NhanVien> boolean exists(Example<S> example) {
        return staffRepository.exists(example);
    }

    @Override
    public <S extends NhanVien, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return staffRepository.findBy(example, queryFunction);
    }

    @Override
    public Optional<NhanVien> findByCmnd(String cmnd) {
        // TODO Auto-generated method stub
        return staffRepository.findByCmnd(cmnd);
    }
}
