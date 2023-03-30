package com.cnpm.baohanhxe.repository;

import com.cnpm.baohanhxe.entity.NhanVien;
import com.cnpm.baohanhxe.entity.Role;
import com.cnpm.baohanhxe.model.RoleName;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepnsitory extends JpaRepository<Role, Long> {
    Optional<Role> findByTenRole(RoleName name);
}
