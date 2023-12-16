package com.example.demo.service;

import com.example.demo.entity.CuaHang;
import com.example.demo.entity.NhanVien;

import java.util.List;
import java.util.Optional;

public interface CuaHang_Service {

    List<CuaHang> getAll();
    void addCH(CuaHang cuaHang);
    void updateCH(CuaHang cuaHang);
    void delete(String id);
    Optional<CuaHang> deltail(String id);

}
