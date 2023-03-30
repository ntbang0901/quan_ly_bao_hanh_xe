package com.cnpm.baohanhxe.model;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto implements Serializable {
    private Long RoleId;
    private String tenRole;

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
