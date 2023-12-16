package com.example.demo.repository;

import com.example.demo.entity.ChiTietSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiTietSanPham_Repository extends JpaRepository<ChiTietSanPham,String> {
}
