package com.example.demo.service.impl;

import com.example.demo.entity.NSX;
import com.example.demo.repository.NSX_Repository;
import com.example.demo.service.NSX_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NSX_Impl implements NSX_Service {

    @Autowired
    private NSX_Repository nsxRepository;
    @Override
    public Page<NSX> getPage(Pageable pageable) {
        return nsxRepository.findAll(pageable);
    }

    @Override
    public void addNSX(NSX nsx) {
        nsxRepository.save(nsx);
    }

    @Override
    public void deleteNSX(String id) {
        nsxRepository.deleteById(id);
    }

    @Override
    public Optional<NSX> detail(String id) {
        return nsxRepository.findById(id);
    }
}
