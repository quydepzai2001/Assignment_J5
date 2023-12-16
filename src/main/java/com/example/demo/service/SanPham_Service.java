package com.example.demo.service;

import com.example.demo.entity.MauSac;
import com.example.demo.entity.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface SanPham_Service {



    Page<SanPham> getPage(Pageable pageable);
    void addSP(SanPham sanPham);
    void delete(String id);
    Optional<SanPham> detailSP(String id);
    List<SanPham> getAll();
}
