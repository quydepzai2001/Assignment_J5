package com.example.demo.service;

import com.example.demo.entity.ChiTietSanPham;
import com.example.demo.entity.CuaHang;
import com.example.demo.entity.DongSP;
import com.example.demo.entity.MauSac;
import com.example.demo.entity.NhanVien;
import com.example.demo.entity.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ChiTietSanPham_Service {

    List<ChiTietSanPham> getAll();
    void addCH(ChiTietSanPham chiTietSanPham);
    void updateCH(ChiTietSanPham chiTietSanPham);
    void delete(String id);
    Optional<ChiTietSanPham> deltail(String id);
    List<SanPham> getSp();
    List<DongSP> getDSP();
    List<MauSac> getMS();
    Page<ChiTietSanPham> getPage(Pageable pageable);


}
