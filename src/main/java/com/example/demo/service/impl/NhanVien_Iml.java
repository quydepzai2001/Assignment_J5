package com.example.demo.service.impl;

import com.example.demo.entity.ChucVu;
import com.example.demo.entity.CuaHang;
import com.example.demo.entity.DongSP;
import com.example.demo.entity.NhanVien;
import com.example.demo.repository.ChucVu_Repository;
import com.example.demo.repository.CuaHang_Repository;
import com.example.demo.repository.NhanVien_Repository;
import com.example.demo.service.NhanVien__Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhanVien_Iml implements NhanVien__Service {

    @Autowired
    NhanVien_Repository nhanVien_repository;

    @Autowired
    CuaHang_Repository cuaHang_repository;

    @Autowired
    ChucVu_Repository chucVuRepository;


    @Override
    public List<NhanVien> getAll() {
        return nhanVien_repository.findAll();
    }

    @Override
    public void addNv(NhanVien nhanVien) {
        nhanVien_repository.save(nhanVien);
    }

    @Override
    public void updateDv(NhanVien nhanVien) {
        nhanVien_repository.save(nhanVien);
    }

    @Override
    public void delete(String id) {
        nhanVien_repository.deleteById(id);
    }

    @Override
    public Optional<NhanVien> deltail(String id) {
        return  nhanVien_repository.findById(id);
    }

    @Override
    public List<CuaHang> getAllLpb() {
        return cuaHang_repository.findAll();
    }

    @Override
    public List<ChucVu> getAllcv() {
        return chucVuRepository.findAll();
    }

    @Override
    public Page<NhanVien> getPage(Pageable pageable) {
        return nhanVien_repository.findAll(pageable);
    }


}
