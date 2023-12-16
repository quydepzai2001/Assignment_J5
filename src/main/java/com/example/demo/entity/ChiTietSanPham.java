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
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Getter
@Setter
@Entity
@Table(name = "ChiTietSP")
public class ChiTietSanPham {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private String id;

    @Column(name = "NamBH")
    @NotNull( message = "namBh ko de trong ")
    private Integer namBh;

    @Column(name = "MoTa")
    @NotEmpty( message = "moTa ko de trong ")
    private String moTa;

    @Column(name = "SoLuongTon")
    @NotNull( message = "soLuongTon ko de trong ")
    private Integer soLuongTon;

    @Column(name = "GiaNhap")
    @NotNull( message = "giaNhap ko de trong ")
    private Double giaNhap;

    @Column(name = "GiaBan")
    @NotNull( message = "giaBan ko de trong")
    private Double giaBan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdSP",referencedColumnName = "id")
    private SanPham sanPhams;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdMauSac",referencedColumnName = "id")
    private MauSac mauSacs;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdDongSP",referencedColumnName = "id")
    private DongSP dongSPs;






}
