package com.example.demo.service.impl;

import com.example.demo.entity.DongSP;
import com.example.demo.repository.DongSP_Repository;
import com.example.demo.service.DongSP_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DongSP_Impl implements DongSP_Service {

    @Autowired
    DongSP_Repository dongSPRepository;


    @Override
    public List<DongSP> getAll() {
        return dongSPRepository.findAll();
    }

    @Override
    public void addDSP(DongSP dongSP) {
        dongSPRepository.save(dongSP);
    }

    @Override
    public void updateDSP(DongSP dongSP) {
        dongSPRepository.save(dongSP);
    }

    @Override
    public void deleteDSP(String id) {
dongSPRepository.deleteById(id);
    }

    @Override
    public Optional<DongSP> deltail(String id) {
        return dongSPRepository.findById(id);
    }

    @Override
    public Page<DongSP> getPage(Pageable pageable) {
        return dongSPRepository.findAll(pageable);
    }
}
