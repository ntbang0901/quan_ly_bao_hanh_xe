package com.cnpm.baohanhxe.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table
@IdClass(CT_PBHId.class)
public class CT_PhieuBH implements Serializable {

    @EmbeddedId
    @ManyToOne()
    @JoinColumn( name ="maPBH",insertable = false, updatable = false)
    private  PhieuBaoHanh phieuBaoHanh;

    @EmbeddedId
    @ManyToOne()
    @JoinColumn(name = "maPhutung", insertable = false, updatable = false)
    private PhuTung phuTung;



    @Column(nullable = false)
    private Long soluong;
    public PhieuBaoHanh getPhieuBaoHanh() {
        return phieuBaoHanh;
    }

    public void setPhieuBaoHanh(PhieuBaoHanh phieuBaoHanh) {
        this.phieuBaoHanh = phieuBaoHanh;
    }

    public PhuTung getPhuTung() {
        return phuTung;
    }

    public void setPhuTung(PhuTung phuTung) {
        this.phuTung = phuTung;
    }

    public Long getSoluong() {
        return soluong;
    }

    public void setSoluong(Long soluong) {
        this.soluong = soluong;
    }
}
