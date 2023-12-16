package com.example.demo.service;

import com.example.demo.entity.ChucVu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ChucVu_Service {

    List<ChucVu> getAll();
    Optional<ChucVu> detail(String id);
    void addChucVu(ChucVu chucVu);
    void delete(String id);
    Page<ChucVu> page(Pageable pageable);
}
