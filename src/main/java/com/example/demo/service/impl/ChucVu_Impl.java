package com.example.demo.service.impl;

import com.example.demo.entity.ChucVu;
import com.example.demo.repository.ChucVu_Repository;
import com.example.demo.service.ChucVu_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChucVu_Impl implements ChucVu_Service {

    @Autowired
    ChucVu_Repository chucVuRepository;


    @Override
    public List<ChucVu> getAll() {
        return chucVuRepository.findAll();
    }

    @Override
    public Optional<ChucVu> detail(String id) {
        return chucVuRepository.findById(id);
    }

    @Override
    public void addChucVu(ChucVu chucVu) {
        chucVuRepository.save(chucVu);
    }

    @Override
    public void delete(String id) {
        chucVuRepository.deleteById(id);
    }

    @Override
    public Page<ChucVu> page(Pageable pageable) {
        return chucVuRepository.findAll(pageable);
    }
}
