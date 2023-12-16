package com.example.demo.service;

import com.example.demo.entity.CuaHang;
import com.example.demo.entity.DongSP;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface DongSP_Service {
    List<DongSP> getAll();
    void addDSP(DongSP dongSP);
    void updateDSP(DongSP dongSP);
    void deleteDSP(String id);
    Optional<DongSP> deltail(String id);
    Page<DongSP> getPage(Pageable pageable);
}
