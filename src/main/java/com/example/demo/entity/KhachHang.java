package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;

@Entity
@Table(name = "KhachHang")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @Column(name = "ma")
    @NotEmpty(message = "khong dc de trong ma")
    private String ma;

    @Column(name = "ten")
    @NotEmpty(message = "khong dc de trong ten")
    private String ten;

    @Column(name = "TenDem")
    @NotEmpty(message = "khong dc de trong ten dem")
    private String tenDem;

    @Column(name = "Ho")
    @NotEmpty(message = "khong dc de trong ho")
    private String ho;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "khong de trong ngay sinh")
    @Column(name = "NgaySinh")
    private String ngaySinh;

    @Column(name = "SDT")
    @NotEmpty( message = "khong dc de trong sdt")
    private String sdt;

    @Column(name = "DiaChi")
    @NotEmpty(message = "khong dc de trong dia chi")
    private String diaChi;

    @Column(name = "ThanhPho")
    @NotEmpty(message = "khong dc de trong thanh pho")
    private String thanhPho;

    @Column(name = "QuocGia")
    @NotEmpty(message = "khong dc de trong quoc gia")
    private String quocGia;

    @Column(name = "MatKhau")
    @NotEmpty(message = "khong dc de trong mat khau")
    private String matKhau;

    @OneToMany(mappedBy = "khachHangs")
    private List<GioHang> gioHangs;
}