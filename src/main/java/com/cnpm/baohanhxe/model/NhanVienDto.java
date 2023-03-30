package com.cnpm.baohanhxe.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NhanVienDto implements Serializable {
	private Long maNV;
	@NotEmpty(message = "Trường này không được bỏ trống")
	private String ho;
	@NotEmpty(message = "Trường này không được bỏ trống")
	private String ten;
	@NotNull(message = "Trường này không được bỏ trống")
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date ngaySinh;
	@Pattern(regexp="0[0-9\\s.-]{9,13}",message="Số điện thoại không hợp lệ")
	private String sdt;

	@Pattern(regexp="^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$",message="Email không hợp lệ")
	private String email;
	@NotEmpty(message = "Trường này không được bỏ trống")
	private String quequan;
	@Pattern(regexp="[0-9]{12}",message="CMND không hợp lệ")
	private String cmnd;
	private Boolean gender;
	private Long mataikhoan;
	private Set<PhieuBaoHanhDto> phieuBHs;
	private Boolean isEdit = false;

	public Long getMaNV() {
		return maNV;
	}

	public void setMaNV(Long maNV) {
		this.maNV = maNV;
	}

	public String getHo() {
		return ho;
	}

	public void setHo(String ho) {
		this.ho = ho;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQuequan() {
		return quequan;
	}

	public void setQuequan(String quequan) {
		this.quequan = quequan;
	}

	public String getCmnd() {
		return cmnd;
	}

	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public Long getMataikhoan() {
		return mataikhoan;
	}

	public void setMataikhoan(Long mataikhoan) {
		this.mataikhoan = mataikhoan;
	}

	public Set<PhieuBaoHanhDto> getPhieuBHs() {
		return phieuBHs;
	}

	public void setPhieuBHs(Set<PhieuBaoHanhDto> phieuBHs) {
		this.phieuBHs = phieuBHs;
	}

	public Boolean getEdit() {
		return isEdit;
	}

	public void setEdit(Boolean edit) {
		isEdit = edit;
	}
}
