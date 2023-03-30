package com.cnpm.baohanhxe.model;

import lombok.*;

import javax.validation.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor

public class PhuTungDto implements Serializable {

    private Long maPhutung;
    @NotEmpty(message = "Trường này không được bỏ trống")
    private String tenPhutung;

    
    private String image;

    private MultipartFile imageFile;

    
    private BigDecimal gia;

    private Integer soLoung;

    private Long maLoaiPhutung;
    private String tenLoaiPhutung;

    
    

    private Boolean isEdit = false;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public MultipartFile getImageFile() {
        return imageFile;
    }

    public void setImageFile(MultipartFile imageFile) {
        this.imageFile = imageFile;
    }

    public BigDecimal getGia() {
        return gia;
    }

    public void setGia(BigDecimal gia) {
        this.gia = gia;
    }
    public Integer getSoLuong(){
        return soLoung;
    }

    public void setSoLuong(Integer soLuong){
        this.soLoung = soLuong;
    }
    public Long getMaLoaiPhutung() {
        return maLoaiPhutung;
    }

    public void setMaLoaiPhutung(Long maLoaiPhutung) {
        this.maLoaiPhutung = maLoaiPhutung;
    }

    

    public String getTenLoaiPhutung() {
        return tenLoaiPhutung;
    }

    public void setTenLoaiPhutung(String tenLoaiPhutung) {
        this.tenLoaiPhutung = tenLoaiPhutung;
    }

    public Boolean getEdit() {
        return isEdit;
    }

    public void setEdit(Boolean edit) {
        isEdit = edit;
    }
}
