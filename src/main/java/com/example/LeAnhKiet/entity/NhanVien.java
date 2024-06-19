package com.example.LeAnhKiet.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "nhanvien")
public class NhanVien {
    @Id
    @Column(name = "Ma_NV")
    private String maNhanVien;

    @Column(name = "Ten_NV")
    private String tenNhanVien;

    @Column(name = "Phai")
    private String phai;

    @Column(name = "Noi_Sinh")
    private String noiSinh;

    @ManyToOne
    @JoinColumn(name = "Ma_Phong")
    private com.example.LeAnhKiet.entity.PhongBan phongBan;

    @Column(name = "Luong")
    private int luong;
}
