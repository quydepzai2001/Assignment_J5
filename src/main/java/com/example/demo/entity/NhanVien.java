package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Getter
@Setter
@Entity
@Table(name = "NhanVien")
public class NhanVien {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private String id;

    @NotEmpty( message = "Ma ko de trong ")
    @Column(name = "Ma")
    private String ma;

    @NotEmpty( message = "Ten ko de trong ")
    @Column(name = "Ten")
    private String ten;

    @NotEmpty( message = "TenDem ko de trong ")
    @Column(name = "TenDem")
    private String tenDem;

    @NotEmpty( message = "Ho ko de trong ")
    @Column(name = "Ho")
    private String ho;

    @NotNull( message = "GioiTinh ko de trong ")
    @Column(name = "GioiTinh")
    private Boolean gioiTinh;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull( message = "NgaySinh ko de trong ")
    @Column(name = "NgaySinh")
    private Date ngaySinh;

    @NotEmpty( message = "DiaChi ko de trong ")
    @Column(name = "DiaChi")
    private String diaChi;

    @NotEmpty( message = "Sdt ko de trong ")
    @Column(name = "Sdt")
    private String sdt;

    @NotEmpty( message = "MatKhau ko de trong ")
    @Column(name = "MatKhau")
    private String matKhau;

    @NotNull( message = "trangThai ko de trong ")
    @Column(name = "TrangThai")
    private Integer trangThai;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdCH",referencedColumnName = "id")
    private CuaHang listCuaHang;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdCV",referencedColumnName = "id")
    private ChucVu chucVus;
}
