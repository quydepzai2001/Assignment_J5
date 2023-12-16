package com.example.demo.service.impl;

import com.example.demo.entity.KhachHang;
import com.example.demo.repository.KhachHang_Repository;
import com.example.demo.service.KhachHang_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KhachHang_Impl implements KhachHang_Service {

    @Autowired
    private KhachHang_Repository khachHangRepository;


    @Override
    public Page<KhachHang> getPage(Pageable pageable) {
        return khachHangRepository.findAll(pageable);
    }

    @Override
    public void addKH(KhachHang khachHang) {
        khachHangRepository.save(khachHang);
    }

    @Override
    public void delete(String id) {
        khachHangRepository.deleteById(id);
    }

    @Override
    public Optional<KhachHang> detail(String id) {
        return khachHangRepository.findById(id);
    }

}
