package com.cnpm.baohanhxe.service.Impl;

import com.cnpm.baohanhxe.entity.Role;
import com.cnpm.baohanhxe.model.RoleName;
import com.cnpm.baohanhxe.repository.RoleRepnsitory;
import com.cnpm.baohanhxe.service.AccountService;
import com.cnpm.baohanhxe.service.RoleService;
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
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepnsitory roleRepnsitory;

    @Override
    public Optional<Role> findByTenRole(RoleName name) {
        return roleRepnsitory.findByTenRole(name);
    }

    @Autowired
    private AccountService accountService;


    @Override
    public List<Role> findAll() {
        return roleRepnsitory.findAll();
    }

    @Override
    public List<Role> findAll(Sort sort) {
        return roleRepnsitory.findAll(sort);
    }

    @Override
    public List<Role> findAllById(Iterable<Long> longs) {
        return roleRepnsitory.findAllById(longs);
    }

    @Override
    public <S extends Role> List<S> saveAll(Iterable<S> entities) {
        return roleRepnsitory.saveAll(entities);
    }

    @Override
    public void flush() {
        roleRepnsitory.flush();
    }

    @Override
    public <S extends Role> S saveAndFlush(S entity) {
        return roleRepnsitory.saveAndFlush(entity);
    }

    @Override
    public <S extends Role> List<S> saveAllAndFlush(Iterable<S> entities) {
        return roleRepnsitory.saveAllAndFlush(entities);
    }

    @Override
    @Deprecated
    public void deleteInBatch(Iterable<Role> entities) {
        roleRepnsitory.deleteInBatch(entities);
    }

    @Override
    public void deleteAllInBatch(Iterable<Role> entities) {
        roleRepnsitory.deleteAllInBatch(entities);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {
        roleRepnsitory.deleteAllByIdInBatch(longs);
    }

    @Override
    public void deleteAllInBatch() {
        roleRepnsitory.deleteAllInBatch();
    }

    @Override
    @Deprecated
    public Role getOne(Long aLong) {
        return roleRepnsitory.getOne(aLong);
    }

    @Override
    @Deprecated
    public Role getById(Long aLong) {
        return roleRepnsitory.getById(aLong);
    }

    @Override
    public Role getReferenceById(Long aLong) {
        return roleRepnsitory.getReferenceById(aLong);
    }

    @Override
    public <S extends Role> List<S> findAll(Example<S> example) {
        return roleRepnsitory.findAll(example);
    }

    @Override
    public <S extends Role> List<S> findAll(Example<S> example, Sort sort) {
        return roleRepnsitory.findAll(example, sort);
    }

    @Override
    public Page<Role> findAll(Pageable pageable) {
        return roleRepnsitory.findAll(pageable);
    }

    @Override
    public <S extends Role> S save(S entity) {
        return roleRepnsitory.save(entity);
    }

    @Override
    public Optional<Role> findById(Long aLong) {
        return roleRepnsitory.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return roleRepnsitory.existsById(aLong);
    }

    @Override
    public long count() {
        return roleRepnsitory.count();
    }

    @Override
    public void deleteById(Long aLong) {
        roleRepnsitory.deleteById(aLong);
    }

    @Override
    public void delete(Role entity) {
        roleRepnsitory.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        roleRepnsitory.deleteAllById(longs);
    }

    @Override
    public void deleteAll(Iterable<? extends Role> entities) {
        roleRepnsitory.deleteAll(entities);
    }


    @Override
    public void deleteAll() {
        roleRepnsitory.deleteAll();
    }

    @Override
    public <S extends Role> Optional<S> findOne(Example<S> example) {
        return roleRepnsitory.findOne(example);
    }

    @Override
    public <S extends Role> Page<S> findAll(Example<S> example, Pageable pageable) {
        return roleRepnsitory.findAll(example, pageable);
    }

    @Override
    public <S extends Role> long count(Example<S> example) {
        return roleRepnsitory.count(example);
    }

    @Override
    public <S extends Role> boolean exists(Example<S> example) {
        return roleRepnsitory.exists(example);
    }

    @Override
    public <S extends Role, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return roleRepnsitory.findBy(example, queryFunction);
    }
}
