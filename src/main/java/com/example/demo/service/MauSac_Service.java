package com.example.demo.service;

import com.example.demo.entity.DongSP;
import com.example.demo.entity.MauSac;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface MauSac_Service {

    List<MauSac> getAll();
    void addMS(MauSac mauSac);
    void updateMS(MauSac mauSac);
    void deleteMS(String id);
    Optional<MauSac> deltail(String id);
    Page<MauSac> getPage(Pageable pageable);
}
