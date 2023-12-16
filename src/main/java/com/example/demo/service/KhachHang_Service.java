package com.example.demo.service;

import com.example.demo.entity.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface KhachHang_Service {
    Page<KhachHang> getPage(Pageable pageable);
    void addKH(KhachHang khachHang);
    void delete(String id);
    Optional<KhachHang> detail(String id);
}
