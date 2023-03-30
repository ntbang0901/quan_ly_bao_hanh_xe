package com.cnpm.baohanhxe.entity;

import lombok.*;
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
@Table
public class PhieuBaoHanh  implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MAPHIEUBAOHANH")
	private Long maPBH;

	@Temporal(TemporalType.DATE)
	@Column(name = "NGAYLAP",nullable = false)
	private Date ngayLap;

	@Column(nullable = false)
	private short status;


	@Column(length = 500, nullable = false, columnDefinition = "nvarchar(500)")
	private String tinhTrangxe;

	@Column(length = 500, nullable = false, columnDefinition = "nvarchar(500)")
	private String noiDungBaoHanh;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@Column(name = "NGAYNHAN")
	private Date ngayNhan;

	@ManyToOne
	@JoinColumn(name = "MANV")
	private NhanVien maNVBH;


	@ManyToOne
	@JoinColumn(name = "MAXE")
	private Xe maXeBH;


	@OneToMany(mappedBy = "phieuBaoHanh",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<CT_PhieuBH> ct_phieuBHS;

	public Long getMaPBH() {
		return maPBH;
	}

	public void setMaPBH(Long maPBH) {
		this.maPBH = maPBH;
	}

	public Date getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}

	public short getStatus() {
		return status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public String getTinhTrangxe() {
		return tinhTrangxe;
	}

	public void setTinhTrangxe(String tinhTrangxe) {
		this.tinhTrangxe = tinhTrangxe;
	}

	public String getNoiDungBaoHanh() {
		return noiDungBaoHanh;
	}

	public void setNoiDungBaoHanh(String noiDungBaoHanh) {
		this.noiDungBaoHanh = noiDungBaoHanh;
	}

	public Date getNgayNhan() {
		return ngayNhan;
	}

	public void setNgayNhan(Date ngayNhan) {
		this.ngayNhan = ngayNhan;
	}

	public NhanVien getMaNVBH() {
		return maNVBH;
	}

	public void setMaNVBH(NhanVien maNVBH) {
		this.maNVBH = maNVBH;
	}

	public Xe getMaXeBH() {
		return maXeBH;
	}

	public void setMaXeBH(Xe maXeBH) {
		this.maXeBH = maXeBH;
	}

	public Set<CT_PhieuBH> getCt_phieuBHS() {
		return ct_phieuBHS;
	}

	public void setCt_phieuBHS(Set<CT_PhieuBH> ct_phieuBHS) {
		this.ct_phieuBHS = ct_phieuBHS;
	}
}
