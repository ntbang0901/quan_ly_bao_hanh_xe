package com.cnpm.baohanhxe.model;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoaiPhuTungDto implements Serializable {
	private Long maLoaiPhutung;
	@NotEmpty(message = "Tên loại không được để trống!")
	private String tenLoai;
	

	private Boolean isEdit = false;

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


	public Boolean getEdit() {
		return isEdit;
	}

	public void setEdit(Boolean edit) {
		isEdit = edit;
	}
}


