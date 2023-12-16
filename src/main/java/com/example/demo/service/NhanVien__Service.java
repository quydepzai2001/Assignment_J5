package com.example.demo.service;

import com.example.demo.entity.ChucVu;
import com.example.demo.entity.CuaHang;
import com.example.demo.entity.DongSP;
import com.example.demo.entity.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface NhanVien__Service {

    List<NhanVien> getAll();
    void addNv(NhanVien nhanVien);
    void updateDv(NhanVien nhanVien);
    void delete(String id);
    Optional<NhanVien> deltail(String id);
    List<CuaHang> getAllLpb();
    List<ChucVu> getAllcv();
    Page<NhanVien> getPage(Pageable pageable);


}
