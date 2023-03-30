package com.cnpm.baohanhxe.model;

import com.cnpm.baohanhxe.entity.Xe;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CT_PhieubhDto implements Serializable {

	private Long maPBH;
	private Long maPhutung;
	
	
	private String tenPhutung;
	private Long soLuong;
	private BigDecimal gia;
	private Integer thanhTien;


	public Long getMaPBH() {
		return maPBH;
	}

	public void setMaPBH(Long maPBH) {
		this.maPBH = maPBH;
	}

	public Long getMaPhutung() {
		return maPhutung;
	}

	public void setMaPhutung(Long maPhutung) {
		this.maPhutung = maPhutung;
	}

	public String getTenPhutung() {
		return tenPhutung;
	}

	public void setTenPhutung(String tenPhutung) {
		this.tenPhutung = tenPhutung;
	}

	public Integer getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(Integer thanhTien) {
		this.thanhTien = thanhTien;
	}

	public Long getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(Long soLuong) {
		this.soLuong = soLuong;
	}
}
