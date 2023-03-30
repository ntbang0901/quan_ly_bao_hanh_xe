package com.cnpm.baohanhxe.entity;

import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;
@Embeddable
public class CT_PBHId implements Serializable {

    private  Long phieuBaoHanh;
    private Long phuTung;

    public CT_PBHId() {
    }
    public CT_PBHId(Long phieuBaoHanh) {
        this.phieuBaoHanh = phieuBaoHanh;
    }

    public Long getPhieuBaoHanh() {
        return phieuBaoHanh;
    }

    public void setPhieuBaoHanh(Long phieuBaoHanh) {
        this.phieuBaoHanh = phieuBaoHanh;
    }

    public Long getPhuTung() {
        return phuTung;
    }

    public void setPhuTung(Long phuTung) {
        this.phuTung = phuTung;
    }

    @Override
    public int hashCode() {
        return Objects.hash(phieuBaoHanh, phuTung);
    }
}
