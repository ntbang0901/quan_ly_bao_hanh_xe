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
public class Xe  implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long maXe;

	@Column(nullable = false, columnDefinition = "nvarchar(200)" )
	private String soXe;

	@Column(length = 100,columnDefinition = "nvarchar(200)")
	private String tenXe;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@Column(nullable = false)
	private Date ngayMua;
	
	@Column(nullable = false)
	private Boolean trangThaiBH;
	
	@Column(nullable = false)
	private Integer tGBH;
	
	@ManyToOne
	@JoinColumn(name = "maLoaiXe")
	private LoaiXe loaixe;

	@ManyToOne
	@JoinColumn(name = "maKhach")
	private KhachHang khachHang;

	@OneToMany(mappedBy = "maXeBH",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<PhieuBaoHanh> phieuBHXes;


	public Long getMaXe() {
		return maXe;
	}

	public void setMaXe(Long maXe) {
		this.maXe = maXe;
	}

	public String getSoXe() {
		return soXe;
	}

	public void setSoXe(String soXe) {
		this.soXe = soXe;
	}

	public String getTenXe() {
		return tenXe;
	}

	public void setTenXe(String tenXe) {
		this.tenXe = tenXe;
	}

	public Date getNgayMua() {
		return ngayMua;
	}

	public void setNgayMua(Date ngayMua) {
		this.ngayMua = ngayMua;
	}

	public Boolean getTrangThaiBH() {
		return trangThaiBH;
	}

	public void setTrangThaiBH(Boolean trangThaiBH) {
		this.trangThaiBH = trangThaiBH;
	}

	public Integer gettGBH() {
		return tGBH;
	}

	public void settGBH(Integer tGBH) {
		this.tGBH = tGBH;
	}

	public LoaiXe getLoaixe() {
		return loaixe;
	}

	public void setLoaixe(LoaiXe loaixe) {
		this.loaixe = loaixe;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public Set<PhieuBaoHanh> getPhieuBHXes() {
		return phieuBHXes;
	}

	public void setPhieuBHXes(Set<PhieuBaoHanh> phieuBHXes) {
		this.phieuBHXes = phieuBHXes;
	}
}
