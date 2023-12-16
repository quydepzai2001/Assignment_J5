package com.example.demo.service.impl;

import com.example.demo.entity.CuaHang;
import com.example.demo.repository.CuaHang_Repository;
import com.example.demo.service.CuaHang_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CuaHang_Impl implements CuaHang_Service {

    @Autowired
    CuaHang_Repository cuaHang_repository;


    @Override
    public List<CuaHang> getAll() {
        return cuaHang_repository.findAll();
    }

    @Override
    public void addCH(CuaHang cuaHang) {
    cuaHang_repository.save(cuaHang);
    }

    @Override
    public void updateCH(CuaHang cuaHang) {
        cuaHang_repository.save(cuaHang);

    }

    @Override
    public void delete(String id) {
    cuaHang_repository.deleteById(id);
    }

    @Override
    public Optional<CuaHang> deltail(String id) {
        return cuaHang_repository.findById(id);
    }
}
