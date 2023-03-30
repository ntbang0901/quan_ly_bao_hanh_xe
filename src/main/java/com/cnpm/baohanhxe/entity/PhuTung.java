package com.cnpm.baohanhxe.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PhuTung")
public class PhuTung implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_phutung")
    private Long maPhutung;

    @Column(length = 50,columnDefinition = "nvarchar(50)")
    private String tenPhutung;

    @Column(nullable = false)
	private BigDecimal gia;

    @Column(length = 150, columnDefinition = "nvarchar(150)" )
    private String image;

    @Column()
    private Integer soLoung;

    @ManyToOne
    @JoinColumn(name = "MaLoaiPhuTung")
    private LoaiPhuTung maLoaiPhutung;

    @OneToMany(mappedBy = "phuTung", fetch = FetchType.LAZY)
    private Set<CT_PhieuBH> ct_phieuBHS;

    

    public Long getMaPhutung() {
        return maPhutung;
    }

    public void setMaPhutung(Long maPhutung) {
        this.maPhutung = maPhutung;
    }

    public Integer getSoLuong(){
        return soLoung;
    }

    public void setSoLuong(Integer soLuong){
        this.soLoung = soLuong;
    }

    public String getTenPhutung() {
        return tenPhutung;
    }

    public void setTenPhutung(String tenPhutung) {
        this.tenPhutung = tenPhutung;
    }

    public String getImage(){
        return image;
    }

    public void setImage(String image){
        this.image = image;
    }

    public LoaiPhuTung getLoaiPhutung() {
        return maLoaiPhutung;
    }

    public BigDecimal getGia(){
        return gia;
    }

    public void setGia(BigDecimal gia){
        this.gia = gia;
    }

    public void setLoaiPhutung(LoaiPhuTung maLoaiPhutung) {
        this.maLoaiPhutung = maLoaiPhutung;
    }

    public Set<CT_PhieuBH> getCt_phieuBHS() {
        return ct_phieuBHS;
    }

    public void setCt_phieuBHS(Set<CT_PhieuBH> ct_phieuBHS) {
        this.ct_phieuBHS = ct_phieuBHS;
    }

    
}
