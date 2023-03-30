package com.cnpm.baohanhxe.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role implements Serializable  {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long RoleId;
    private String tenRole;

    // remaining getters and setters


    public Long getRoleId() {
        return RoleId;
    }

    public void setRoleId(Long roleId) {
        RoleId = roleId;
    }

    public String getTenRole() {
        return tenRole;
    }

    public void setTenRole(String tenRole) {
        this.tenRole = tenRole;
    }
}
