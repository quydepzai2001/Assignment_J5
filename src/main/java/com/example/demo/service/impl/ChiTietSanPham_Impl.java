package com.example.demo.service.impl;

import com.example.demo.entity.ChiTietSanPham;
import com.example.demo.entity.DongSP;
import com.example.demo.entity.MauSac;
import com.example.demo.entity.SanPham;
import com.example.demo.repository.ChiTietSanPham_Repository;
import com.example.demo.repository.DongSP_Repository;
import com.example.demo.repository.MauSac_Repository;
import com.example.demo.repository.SanPham_Repostiory;
import com.example.demo.service.ChiTietSanPham_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChiTietSanPham_Impl implements ChiTietSanPham_Service {

    @Autowired
    ChiTietSanPham_Repository chiTietSanPhamRepository;

    @Autowired
    SanPham_Repostiory sanPhamRepostiory;

    @Autowired
    DongSP_Repository dongSPRepository;

    @Autowired
    MauSac_Repository mauSacRepository;

    @Override
    public List<ChiTietSanPham> getAll() {
        return chiTietSanPhamRepository.findAll();
    }

    @Override
    public void addCH(ChiTietSanPham chiTietSanPham) {
chiTietSanPhamRepository.save(chiTietSanPham);
    }

    @Override
    public void updateCH(ChiTietSanPham chiTietSanPham) {
        chiTietSanPhamRepository.save(chiTietSanPham);

    }

    @Override
    public void delete(String id) {
        chiTietSanPhamRepository.deleteById(id);
    }

    @Override
    public Optional<ChiTietSanPham> deltail(String id) {
        return chiTietSanPhamRepository.findById(id);
    }

    @Override
    public List<SanPham> getSp() {
        return sanPhamRepostiory.findAll();
    }

    @Override
    public List<DongSP> getDSP() {
        return dongSPRepository.findAll();
    }

    @Override
    public List<MauSac> getMS() {
        return mauSacRepository.findAll();
    }

    @Override
    public Page<ChiTietSanPham> getPage(Pageable pageable) {
        return chiTietSanPhamRepository.findAll(pageable);
    }


}
