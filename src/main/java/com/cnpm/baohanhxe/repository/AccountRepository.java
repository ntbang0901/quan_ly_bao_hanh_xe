package com.cnpm.baohanhxe.repository;

import com.cnpm.baohanhxe.entity.Role;
import com.cnpm.baohanhxe.entity.TaiKhoan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.Optional;

@Repository
@Transactional
public interface AccountRepository extends JpaRepository<TaiKhoan, Long> {
    Page<TaiKhoan> findByUsernameContaining(String username, Pageable pageable);

    Optional<TaiKhoan> findByUsername(String username);
    @Query("SELECT u from TaiKhoan u Where u.username = :username ")
    public TaiKhoan getUserByUsername(@Param("username") String username);

    Optional<TaiKhoan> findByUser_MaNV(Long maNV);

}

