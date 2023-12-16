package com.example.demo.service.impl;

import com.example.demo.entity.SanPham;
import com.example.demo.repository.SanPham_Repostiory;
import com.example.demo.service.SanPham_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SanPham_Impl implements SanPham_Service {

    @Autowired
    SanPham_Repostiory sanPhamRepository;


    @Override
    public Page<SanPham> getPage(Pageable pageable) {
        return sanPhamRepository.findAll(pageable);
    }

    @Override
    public void addSP(SanPham sanPham) {
        sanPhamRepository.save(sanPham);
    }

    @Override
    public void delete(String id) {
        sanPhamRepository.deleteById(id);
    }

    @Override
    public Optional<SanPham> detailSP(String id) {
        return sanPhamRepository.findById(id);
    }

    @Override
    public List<SanPham> getAll() {
        return sanPhamRepository.findAll();
    }
}
