package com.cnpm.baohanhxe.model;


import java.io.Serializable;
import java.util.List;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TaiKhoanDto implements Serializable {

	private Long id;
	@Pattern(regexp="^[a-z][^\\W_]{7,14}$",message="Username phải có ít nhất 6 ký tự")
	private String username;
	private String password;
	@NotNull(message = "Trường này không được bỏ trống")
	private Long RoleId;
	private String tenRole;
	@NotNull(message = "Trường này không được bỏ trống")
	private Long maNV;
	private String tenNv;

		private Boolean enabled= true;
		private Boolean isEdit = false;
		private Boolean isExist = false;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

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

	public Long getMaNV() {
		return maNV;
	}

	public void setMaNV(Long maNV) {
		this.maNV = maNV;
	}

	public String getTenNv() {
		return tenNv;
	}

	public void setTenNv(String tenNv) {
		this.tenNv = tenNv;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Boolean getEdit() {
		return isEdit;
	}

	public void setEdit(boolean edit) {
		isEdit = edit;
	}

	public Boolean getExist() {
		return isExist;
	}

	public void setExist(boolean exist) {
		isExist = exist;
	}
}
