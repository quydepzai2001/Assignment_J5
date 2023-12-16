package com.example.demo.service.impl;

import com.example.demo.entity.MauSac;
import com.example.demo.repository.MauSac_Repository;
import com.example.demo.service.MauSac_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MauSac_impl implements MauSac_Service {

    @Autowired
    MauSac_Repository mauSacRepository;

    @Override
    public List<MauSac> getAll() {
        return mauSacRepository.findAll();
    }

    @Override
    public void addMS(MauSac mauSac) {
        mauSacRepository.save(mauSac);
    }

    @Override
    public void updateMS(MauSac mauSac) {
        mauSacRepository.save(mauSac);
    }

    @Override
    public void deleteMS(String id) {
        mauSacRepository.deleteById(id);
    }

    @Override
    public Optional<MauSac> deltail(String id) {
        return mauSacRepository.findById(id);
    }

    @Override
    public Page<MauSac> getPage(Pageable pageable) {
        return mauSacRepository.findAll(pageable);
    }
}
