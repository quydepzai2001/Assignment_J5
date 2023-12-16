package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Getter
@Setter
@Entity
@Table(name = "CuaHang")
public class CuaHang {

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

    @NotEmpty( message = "DiaChi ko de trong ")
    @Column(name = "DiaChi")
    private String diaChi;

    @NotEmpty( message = "ThanhPho ko de trong ")
    @Column(name = "ThanhPho")
    private String thanhPho;

    @NotEmpty( message = "QuocGia ko de trong ")
    @Column(name = "QuocGia")
    private String quocGia;

    @OneToMany(mappedBy = "listCuaHang")
    private List<NhanVien> nhanViens;

}
