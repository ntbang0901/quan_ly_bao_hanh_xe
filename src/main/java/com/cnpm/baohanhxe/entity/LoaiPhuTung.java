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
@Table
public class LoaiPhuTung  implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ma_loai_phu_tung")
	private Long maLoaiPhutung;

	@Column(length = 100,nullable = false)
	private String tenLoai;

	@OneToMany(mappedBy = "maLoaiPhutung",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<PhuTung> phutungs;


	public Long getMaLoaiPhutung() {
		return maLoaiPhutung;
	}

	public void setMaLoaiPhutung(Long maLoaiPhutung) {
		this.maLoaiPhutung = maLoaiPhutung;
	}

	public String getTenLoai() {
		return tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

	public Set<PhuTung> getPhutungs() {
		return phutungs;
	}

	public void setXes(Set<PhuTung> phutungs) {
		this.phutungs = phutungs;
	}
}


