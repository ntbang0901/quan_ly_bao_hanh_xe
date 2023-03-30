package com.cnpm.baohanhxe.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "LoaiXe")
public class LoaiXe  implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long maLoaiXe;

	@Column(length = 100,nullable = false)
	private String tenLoai;

	@Column(nullable = false)
	private Integer soPhanKhoi;

	@OneToMany(mappedBy = "loaixe",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<Xe> xes;


	public Long getMaLoaiXe() {
		return maLoaiXe;
	}

	public void setMaLoaiXe(Long maLoaiXe) {
		this.maLoaiXe = maLoaiXe;
	}

	public String getTenLoai() {
		return tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

	public Integer getSoPhanKhoi() {
		return soPhanKhoi;
	}

	public void setSoPhanKhoi(Integer soPhanKhoi) {
		this.soPhanKhoi = soPhanKhoi;
	}

	public Set<Xe> getXes() {
		return xes;
	}

	public void setXes(Set<Xe> xes) {
		this.xes = xes;
	}
}


