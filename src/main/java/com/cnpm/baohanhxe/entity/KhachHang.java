package com.cnpm.baohanhxe.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class KhachHang implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long maKhach;

	@Column(columnDefinition = "nvarchar(100) not null")
	private String ho;

	@Column(columnDefinition = "nvarchar(50) not null")
	private String ten;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@Column(nullable = false)
	private Date ngaySinh;
	@Column(columnDefinition = "nvarchar(200) not null")
	private String diachi;
	@Column(columnDefinition = "nvarchar(200) not null")
	private String email;
	@Column(length = 20,nullable = false)
	private String sdt;
	@Column(nullable = false)
	private String cmnd;
	@Column(nullable = false)
	private boolean gender;


	@OneToMany(mappedBy = "khachHang",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<Xe> xeCuaKhach = new HashSet<>();


	public Long getMaKhach() {
		return maKhach;
	}

	public void setMaKhach(Long maKhach) {
		this.maKhach = maKhach;
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

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getCmnd() {
		return cmnd;
	}

	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public Set<Xe> getXeCuaKhach() {
		return xeCuaKhach;
	}

	public void setXeCuaKhach(Set<Xe> xeCuaKhach) {
		this.xeCuaKhach = xeCuaKhach;
	}
}
