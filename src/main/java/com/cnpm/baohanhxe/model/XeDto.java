package com.cnpm.baohanhxe.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class XeDto implements Serializable {
	private Long maXe;
	@NotEmpty(message = "Trường này không được bỏ trống")
	private String soXe;
	@NotEmpty(message = "Trường này không được bỏ trống")
	private String tenXe;
	private Boolean trangThaiBH;
	private Long maLoaiXe;
	@NotNull(message = "Trường này không được bỏ trống")
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date ngayMua;
	@NotNull(message = "Trường này không được bỏ trống")
	private Long maKhach;
	private Integer tGBH;
	private boolean isEdit = false;

	public Date getNgayMua() {
		return ngayMua;
	}

	public void setNgayMua(Date ngayMua) {
		this.ngayMua = ngayMua;
	}

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

	public Boolean getTrangThaiBH() {
		return trangThaiBH;
	}

	public void setTrangThaiBH(Boolean trangThaiBH) {
		this.trangThaiBH = trangThaiBH;
	}

	public Long getMaLoaiXe() {
		return maLoaiXe;
	}

	public void setMaLoaiXe(Long maLoaiXe) {
		this.maLoaiXe = maLoaiXe;
	}

	public Long getMaKhach() {
		return maKhach;
	}

	public void setMaKhach(Long maKhach) {
		this.maKhach = maKhach;
	}

	public Integer gettGBH() {
		return tGBH;
	}

	public void settGBH(Integer tGBH) {
		this.tGBH = tGBH;
	}

	public Boolean getIsEdit() {
		return isEdit;
	}

	public void setIsEdit(boolean edit) {
		isEdit = edit;
	}
}
