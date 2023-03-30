package com.cnpm.baohanhxe.service.Impl;

import com.cnpm.baohanhxe.entity.TaiKhoan;
import com.cnpm.baohanhxe.repository.AccountRepository;
import com.cnpm.baohanhxe.repository.RoleRepnsitory;
import com.cnpm.baohanhxe.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;


    @Autowired
    private RoleRepnsitory roleRepnsitory;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public Optional<TaiKhoan> findByUser_MaNV(Long maNV) {
        return accountRepository.findByUser_MaNV(maNV);
    }

    @Override
    public Page<TaiKhoan> findByUsernameContaining(String username, Pageable pageable) {
        return accountRepository.findByUsernameContaining(username, pageable);
    }

    @Override
    public List<TaiKhoan> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public List<TaiKhoan> findAll(Sort sort) {
        return accountRepository.findAll(sort);
    }

    @Override
    public List<TaiKhoan> findAllById(Iterable<Long> longs) {
        return accountRepository.findAllById(longs);
    }

    @Override
    public <S extends TaiKhoan> List<S> saveAll(Iterable<S> entities) {
        return accountRepository.saveAll(entities);
    }

    @Override
    public void flush() {
        accountRepository.flush();
    }

    @Override
    public <S extends TaiKhoan> S saveAndFlush(S entity) {
        return accountRepository.saveAndFlush(entity);
    }

    @Override
    public <S extends TaiKhoan> List<S> saveAllAndFlush(Iterable<S> entities) {
        return accountRepository.saveAllAndFlush(entities);
    }

    @Override
    @Deprecated
    public void deleteInBatch(Iterable<TaiKhoan> entities) {
        accountRepository.deleteInBatch(entities);
    }

    @Override
    public void deleteAllInBatch(Iterable<TaiKhoan> entities) {
        accountRepository.deleteAllInBatch(entities);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {
        accountRepository.deleteAllByIdInBatch(longs);
    }

    @Override
    public void deleteAllInBatch() {
        accountRepository.deleteAllInBatch();
    }

    @Override
    @Deprecated
    public TaiKhoan getOne(Long aLong) {
        return accountRepository.getOne(aLong);
    }

    @Override
    @Deprecated
    public TaiKhoan getById(Long aLong) {
        return accountRepository.getById(aLong);
    }

    @Override
    public TaiKhoan getReferenceById(Long aLong) {
        return accountRepository.getReferenceById(aLong);
    }

    @Override
    public <S extends TaiKhoan> List<S> findAll(Example<S> example) {
        return accountRepository.findAll(example);
    }

    @Override
    public <S extends TaiKhoan> List<S> findAll(Example<S> example, Sort sort) {
        return accountRepository.findAll(example, sort);
    }

    @Override
    public Page<TaiKhoan> findAll(Pageable pageable) {
        return accountRepository.findAll(pageable);
    }

    @Override
    public TaiKhoan getUserByUsername(String username) {
        return accountRepository.getUserByUsername(username);
    }

    @Override
    public Optional<TaiKhoan> findByUsername(String username) {
        return accountRepository.findByUsername(username);
    }




    @Override
    public TaiKhoan save(TaiKhoan taiKhoan) {
        Optional<TaiKhoan> optExist = findByUsername(taiKhoan.getUsername());
        if(optExist.isPresent()){
            if(StringUtils.isEmpty(taiKhoan.getPassword())){
                taiKhoan.setPassword(optExist.get().getPassword());
                return accountRepository.save(taiKhoan);
            }else{
                taiKhoan.setPassword(passwordEncoder.encode(taiKhoan.getPassword()));
                return accountRepository.save(taiKhoan);
            }
        }
        taiKhoan.setPassword(passwordEncoder.encode(taiKhoan.getPassword()));
        return accountRepository.save(taiKhoan);
    }

    @Override
    public Optional<TaiKhoan> findById(Long aLong) {
        return accountRepository.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return accountRepository.existsById(aLong);
    }

    @Override
    public long count() {
        return accountRepository.count();
    }

    @Override
    public void deleteById(Long aLong) {
        accountRepository.deleteById(aLong);
    }

    @Override
    public void delete(TaiKhoan entity) {
        accountRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        accountRepository.deleteAllById(longs);
    }

    @Override
    public void deleteAll(Iterable<? extends TaiKhoan> entities) {
        accountRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        accountRepository.deleteAll();
    }

    @Override
    public <S extends TaiKhoan> Optional<S> findOne(Example<S> example) {
        return accountRepository.findOne(example);
    }

    @Override
    public <S extends TaiKhoan> Page<S> findAll(Example<S> example, Pageable pageable) {
        return accountRepository.findAll(example, pageable);
    }

    @Override
    public <S extends TaiKhoan> long count(Example<S> example) {
        return accountRepository.count(example);
    }

    @Override
    public <S extends TaiKhoan> boolean exists(Example<S> example) {
        return accountRepository.exists(example);
    }

    @Override
    public <S extends TaiKhoan, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return accountRepository.findBy(example, queryFunction);
    }
}
