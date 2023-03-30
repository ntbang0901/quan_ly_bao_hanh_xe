package com.cnpm.baohanhxe.entity;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "NhanVien")
public class NhanVien  implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "manv")
	private Long maNV;

	@Column(columnDefinition = "nvarchar(100) not null")
	private String ho;

	@Column(columnDefinition = "nvarchar(50) not null")
	private String ten;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@Column(nullable = false)
	private Date ngaySinh;
	@Column(columnDefinition = "nvarchar(200) not null")
	private String quequan;
	@Column(columnDefinition = "nvarchar(200) not null")
	private String email;
	@Column(length = 20,nullable = false)
	private String sdt;
	@Column(nullable = false)
	private String cmnd;
	@Column(nullable = false)
	private boolean gender;

	@OneToOne(mappedBy = "user")
	private TaiKhoan taiKhoan;


	@OneToMany(mappedBy = "maNVBH", cascade = CascadeType.ALL)
	private Set<PhieuBaoHanh> phieuBHs;

	

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

	public String getQuequan() {
		return quequan;
	}

	public void setQuequan(String quequan) {
		this.quequan = quequan;
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

	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public Set<PhieuBaoHanh> getPhieuBHs() {
		return phieuBHs;
	}

	public void setPhieuBHs(Set<PhieuBaoHanh> phieuBHs) {
		this.phieuBHs = phieuBHs;
	}

	
}
