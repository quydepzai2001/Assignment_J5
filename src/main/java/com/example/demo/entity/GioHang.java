package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

import java.util.Date;

@Entity
@Table(name = "GioHang")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GioHang {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @Column(name = "ma")
    @NotEmpty(message = "Khong duoc de trong ma")
    private String ma;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Khong duoc de trong ngayTao")
    @Column(name = "NgayTao")
    private Date ngayTao;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Khong duoc de trong ngayThanhToan")
    @Column(name = "NgayThanhToan")
    private Date ngayThanhToan;

    @NotEmpty(message = "Khong duoc de trong Ten Nguoi Nhan")
    @Column(name = "TenNguoiNhan")
    private String tenNguoiNhan;

    @NotEmpty(message = "Khong duoc de trong diaChi")
    @Column(name = "DiaChi")
    private String diaChi;

    @NotEmpty(message = "khong duoc de trong sdt")
    @Column(name = "Sdt")
    private String sdt;

    @NotNull(message = "Khong duoc de trong")
    @Column(name = "TinhTrang")
    private Integer tinhTrang;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdKH",referencedColumnName = "id")
    private KhachHang khachHangs;

}
