package com.cnpm.baohanhxe.model;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoaiXeDto implements Serializable {
	private Long maLoaiXe;
	@NotEmpty(message = "Tên loại không được để trống!")
	private String tenLoai;
	private Integer soPhanKhoi;

	private Boolean isEdit = false;

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

	public Boolean getEdit() {
		return isEdit;
	}

	public void setEdit(Boolean edit) {
		isEdit = edit;
	}
}


