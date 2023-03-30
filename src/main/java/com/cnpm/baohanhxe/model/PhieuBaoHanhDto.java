package com.cnpm.baohanhxe.model;

import com.cnpm.baohanhxe.entity.Xe;

import java.util.List;
import java.util.Map;

import javassist.expr.NewArray;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PhieuBaoHanhDto implements Serializable {

	private Long maPBH;
	@NotNull(message = "Trường này không được bỏ trống")
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date ngayLap;

	@NotNull(message = "Trường này không được bỏ trống")
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date ngayNhan;
	@NotNull(message = "Trường này không được bỏ trống")
	private String tinhTrangxe;
	@NotNull(message = "Trường này không được bỏ trống")
	private String noiDungBaoHanh;
	private Long maNVBH;
	@NotNull(message = "Trường này không được bỏ trống")
	private Long maXeBH;


	private Map<Long, String> phuTung;

	private String tenNV;
	private short status;
	private String soXe;

	private Boolean Edit = false;

	public boolean getisEdit() {
		return Edit;
	}

	public void setIsEdit(boolean edit) {
		Edit = edit;
	}

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

	public Date getNgayNhan() {
		return ngayNhan;
	}

	public void setNgayNhan(Date ngayNhan) {
		this.ngayNhan = ngayNhan;
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

	public Long getMaNVBH() {
		return maNVBH;
	}

	public void setMaNVBH(Long maNVBH) {
		this.maNVBH = maNVBH;
	}

	public Long getMaXeBH() {
		return maXeBH;
	}

	public void setMaXeBH(Long maXeBH) {
		this.maXeBH = maXeBH;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}

	public short getStatus() {
		return status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public String getSoXe() {
		return soXe;
	}

	public void setSoXe(String soXe) {
		this.soXe = soXe;
	}

}
