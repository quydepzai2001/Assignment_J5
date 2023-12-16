package com.example.demo.service;

import com.example.demo.entity.NSX;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface NSX_Service {
    Page<NSX> getPage(Pageable pageable);
    void addNSX(NSX nsx);
    void deleteNSX(String id);
    Optional<NSX> detail(String id);
}
